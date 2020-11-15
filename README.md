> 小湖学院是一个B2C模式的职业技能在线教育系统，分为前台用户系统和后台运营平台。 系统开发阶段使用了前后端分离架构，部署阶段使用了容器技术。

## 后端相关技术：

系统后端接口部分，使用目前市面上流行的SpringBoot+SpringCloud进行微服务架构，使用Feign、Gateway、Hystrix，以及阿里巴巴的Nacos等组件搭建了项目的基础环境。采用MyBatisPlus进行持久层的操作，使用了OAuth2+JWT实现了分布式的访问。除此之外，项目中使用了阿里巴巴的EasyExcel实现对Excel的读写操作，使用了Redis进行首页数据的缓存，使用Git进行代码的版本控制，还整合了Swagger生成接口文档 。

## 前端相关技术：

系统前端部分，使用主流的前端框架Vue，使用Es6的开发规范，采用模块化的开发模式，搭建页面环境使用了Nuxt框架和vue-admin-template模板，使用Element-ui进行页面布局。前端环境中使用Npm进行依赖管理，使用Babel进行代码转换，使用Webpack进行静态资源的打包，采用axios进行Ajax请求调用，使用了ECharts进行数据的图表展示。

## 项目演示

https://www.xn2001.com/archives/542.html

## 项目部署

https://www.xn2001.com/archives/605.html
