> 小湖学院是一个B2C模式的职业技能在线教育系统，分为前台用户系统和后台运营平台。 系统开发阶段使用了前后端分离架构，部署阶段使用了容器技术。

## 后端相关技术：

系统后端接口部分，使用目前市面上流行的SpringBoot+SpringCloud进行微服务架构，使用Feign、Gateway、Hystrix，以及阿里巴巴的Nacos等组件搭建了项目的基础环境。采用MyBatisPlus进行持久层的操作，使用了OAuth2+JWT实现了分布式的访问。除此之外，项目中使用了阿里巴巴的EasyExcel实现对Excel的读写操作，使用了Redis进行首页数据的缓存，使用Git进行代码的版本控制，还整合了Swagger生成接口文档 。

## 前端相关技术：

系统前端部分，使用主流的前端框架Vue，使用Es6的开发规范，采用模块化的开发模式，搭建页面环境使用了Nuxt框架和vue-admin-template模板，使用Element-ui进行页面布局。前端环境中使用Npm进行依赖管理，使用Babel进行代码转换，使用Webpack进行静态资源的打包，采用axios进行Ajax请求调用，使用了ECharts进行数据的图表展示。

## 项目结构

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
│       └── service_vod             // 阿里云vod视频存储
├── sql                         // 数据库文件
│       └── edu_cms.sql             // 前台内容数据库表
│       └── edu_college.sql         // 学院核心数据库表
│       └── edu_statistics.sql      // 统计内容数据库表
│       └── edu_trade.sql           // 订单交易数据表
│       └── edu_ucenter.sql         // 用户信息数据表
```

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

后端，安装完依赖后，修改 application.yml 中的aliyun 配置信息，根据需要选择启动模块。

> 前后端某些依赖随着时间版本推进可能出现不适用等的情况，请根据提示自行解决

> 阿里云VOD依赖不开源，VOD与OSS版本需兼容。

## 项目部署

https://www.xn2001.com/archives/605.html
