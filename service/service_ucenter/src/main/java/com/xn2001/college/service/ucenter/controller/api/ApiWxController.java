package com.xn2001.college.service.ucenter.controller.api;

import com.alibaba.nacos.client.utils.StringUtils;
import com.google.gson.Gson;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.ExceptionUtils;
import com.xn2001.college.common.base.util.HttpClientUtils;
import com.xn2001.college.common.base.util.JwtInfo;
import com.xn2001.college.common.base.util.JwtUtils;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.ucenter.entity.Member;
import com.xn2001.college.service.ucenter.service.MemberService;
import com.xn2001.college.service.ucenter.util.UcenterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 乐心湖
 * @date 2020/8/1 22:31
 **/
@Controller//注意这里没有配置 @RestController
@RequestMapping("/api/ucenter/wx")
@Slf4j
public class ApiWxController {

    @Autowired
    private UcenterProperties ucenterProperties;

    @Autowired
    private MemberService memberService;

    @GetMapping("login")
    public String genQrConnect(HttpSession session) {

        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //处理回调url
        String redirecturi = "";
        try {
            redirecturi = URLEncoder.encode(ucenterProperties.getRedirectUri(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new CollegeException(ResultCodeEnum.URL_ENCODE_ERROR);
        }

        //处理state：生成随机数，存入session
        String state = UUID.randomUUID().toString();
        log.info("生成 state = " + state);
        session.setAttribute("wx_open_state", state);

        String qrcodeUrl = String.format(
                baseUrl,
                ucenterProperties.getAppId(),
                redirecturi,
                state
        );

        return "redirect:" + qrcodeUrl;
    }

    @GetMapping("callback")
    public String callback(String code, String state, HttpSession session) {

        //回调被拉起，并获得code和state参数
        log.info("callback被调用");
        log.info("code = " + code);
        log.info("state = " + state);

        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(state)) {
            log.error("非法回调请求");
            throw new CollegeException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
        }

        String sessionState = (String) session.getAttribute("wx_open_state");
        if (!state.equals(sessionState)) {
            log.error("非法回调请求");
            throw new CollegeException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
        }

        //携带授权临时票据code，和appid以及appsecret请求access_token
        String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> accessTokenParam = new HashMap();
        accessTokenParam.put("appid", ucenterProperties.getAppId());
        accessTokenParam.put("secret", ucenterProperties.getAppSecret());
        accessTokenParam.put("code", code);
        accessTokenParam.put("grant_type", "authorization_code");
        HttpClientUtils client = new HttpClientUtils(accessTokenUrl, accessTokenParam);

        String result = "";
        try {
            //发送请求
            client.get();
            result = client.getContent();
        } catch (Exception e) {
            log.error("获取access_token失败");
            throw new CollegeException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }

        Gson gson = new Gson();
        HashMap<String, Object> resultMap = gson.fromJson(result, HashMap.class);

        //判断微信获取access_token失败的响应
        Object errcodeObj = resultMap.get("errcode");
        if (errcodeObj != null) {
            String errmsg = (String) resultMap.get("errmsg");
            Double errcode = (Double) errcodeObj;
            log.error("获取access_token失败 - " + "message: " + errmsg + ", errcode: " + errcode);
            throw new CollegeException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }

        //微信获取access_token响应成功
        String accessToken = (String) resultMap.get("access_token");
        String openid = (String) resultMap.get("openid");

        log.info("accessToken = " + accessToken);
        log.info("openid = " + openid);

        //根据access_token获取微信用户的基本信息
        //根据openid查询当前用户是否已经使用微信登录过该系统
        Member member = memberService.getByOpenid(openid);
        if (member == null) {

            //向微信的资源服务器发起请求，获取当前用户的用户信息
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
            Map<String, String> baseUserInfoParam = new HashMap();
            baseUserInfoParam.put("access_token", accessToken);
            baseUserInfoParam.put("openid", openid);
            client = new HttpClientUtils(baseUserInfoUrl, baseUserInfoParam);

            String resultUserInfo = null;
            try {
                client.get();
                resultUserInfo = client.getContent();
            } catch (Exception e) {
                log.error(ExceptionUtils.getMessage(e));
                throw new CollegeException(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }

            HashMap<String, Object> resultUserInfoMap = gson.fromJson(resultUserInfo, HashMap.class);
            if (resultUserInfoMap.get("errcode") != null) {
                log.error("获取用户信息失败" + "，message：" + resultMap.get("errmsg"));
                throw new CollegeException(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }

            String nickname = (String) resultUserInfoMap.get("nickname");
            String headimgurl = (String) resultUserInfoMap.get("headimgurl");
            Double sex = (Double) resultUserInfoMap.get("sex");

            //用户注册
            member = new Member();
            member.setOpenid(openid);
            member.setNickname(nickname);
            member.setAvatar(headimgurl);
            member.setSex(sex.intValue());
            memberService.save(member);
        }

        JwtInfo jwtInfo = new JwtInfo();
        jwtInfo.setId(member.getId());
        jwtInfo.setNickname(member.getNickname());
        jwtInfo.setAvatar(member.getAvatar());
        String jwtToken = JwtUtils.getJwtToken(jwtInfo, 1800);

        //携带token跳转
        return "redirect:http://127.0.0.1:3000?token=" + jwtToken;
    }
}
