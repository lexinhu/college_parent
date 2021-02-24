> 本项目供大家开源学习，基于学习阶段的谷粒学院多次迭代优化而来，采用前后端分离架构，部署阶段使用容器技术。
>
> 前台演示地址：http://video-test.xn2001.com
>
> 后台演示地址：不公开，没经济条件。

- 2020.06.04：项目完成。
- 2020.08.15：分类选择更换为更加合理的多级展示。
- 2021.08.18：优化首页展示效果，集成 element-ui 中的走马灯。
- 2021.02.17：由于阿里云vod不开源以及播放器效果不佳等原因，**更换为腾讯云vod视频点播**，后者比前者更加优秀。
- 2021.02.17：阿里云腾讯云sms短信服务后续不再对个人测试用户开放，**建议大家寻找合适的短信平台更替**。（已经审核通过的用户不受影响）
- 2021.02.18：**新增邮箱验证码模块。**
- 2021.02.18：优化了大量的代码，解决上百个已知的 bug。
- 2021.02.18：**舍弃前端的微信支付和微信登录**，后端代码保留供测试学习。
- 2021.02.19：**前端注册页新增邮箱验证码。**

说明：

1. 注册时验证码根据手机号或邮箱发送，同时填写时优先使用手机发送验证码，如需优先使用邮箱，只需在后端代码中调整一下顺序即可。
2. 首页开启了 Redis 缓存，因此某些数据修改不会立即生效，可以关闭缓存或者去 redis 中删除缓存即可。
3. 登录可以自择使用手机号或邮箱。
4. 项目本叫小湖学院，后面线上部署索性改名小湖视频网，割弃部分无时间开发的需求。
5. 在开发时，腾讯云视频播放器还未对 vue 提供支持，因此使用组件集成，非多此一举。

**后端相关技术：**

系统后端接口部分，使用目前市面上流行的 SpringBoot+SpringCloud 进行微服务架构，使用 Feign、Gateway、Hystrix ，以及阿里巴巴的 Nacos 等组件搭建了项目的基础环境。采用 MyBatis-Plus 进行持久层的操作，使用了 OAuth2+JWT 实现了分布式的访问。此外，项目中使用了阿里巴巴的 EasyExcel 实现对 Excel 的读写操作，使用了 Redis 进行首页数据的缓存，使用 Git 进行代码的版本控制，整合了 Swagger 生成接口文档。

```
college_parent                  // 后端项目
├── common                      // 通用代码层
│       └── common_util             // 工具类
│       └── service_base            // 业务通用代码
├── infrastructure              // 对外开放网关层
│       └── api_gateway             // gateway网关
├── service                     // 业务代码层
│       └── service_cms             // 前台内容api
│       └── service_edu             // 后台内容api
│       └── service_oss             // 阿里云oss文件存储
│       └── service_sms             // 阿里云短信分发
│       └── service_statistics      // 统计报表模块
│       └── service_trade           // 课程交易模块
│       └── service_ucenter         // 用户模块
│       └── service_vod             // 腾讯云vod视频存储
├── sql                         // 数据库文件
│       └── edu_cms.sql             // 前台内容数据库表
│       └── edu_college.sql         // 学院核心数据库表
│       └── edu_statistics.sql      // 统计内容数据库表
│       └── edu_trade.sql           // 订单交易数据表
│       └── edu_ucenter.sql         // 用户信息数据表
```

**前端相关技术：**

系统前端部分，使用主流的前端框架 Vue，使用 Es6 的开发规范，采用模块化的开发模式，搭建页面环境使用了 Nuxt 框架和 vue-admin-template 模板，使用 Element-ui 进行页面布局。前端环境中使用 Npm 进行依赖管理，使用 Babel 进行代码转换，使用 Webpack 进行静态资源的打包，采用 axios 进行 Ajax 请求调用。

## 项目演示

https://www.xn2001.com/archives/542.html

## 本地运行

前端（前后台）
https://github.com/lexinhu/college_admin
https://github.com/lexinhu/college_site

后端
https://github.com/lexinhu/college_parent

### 本地启动运行

两个前端，分别 clone 后，执行命令

```
npm install
npm run dev
```

> 前后端某些依赖随着时间版本推进可能出现不适用等的情况，请根据提示自行解决

> 阿里云VOD依赖不开源，VOD与OSS版本需兼容。


