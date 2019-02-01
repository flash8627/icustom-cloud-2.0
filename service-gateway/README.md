zuul路由网关

测试：
启动Eureka注册中心
测试地址：http://localhost:8761/

启动 server-config

启动 user-service 
然后在浏览器输入http://localhost:8801/user/list


测试  
依次运行eureka server -- server config -- user-service(启动两个不同端口) -- service-gateway(ribbon) 

测试地址：http://localhost:1100/api/user/list

- 认证 来源的合法性校验
- 动态路由 断路 隐藏内部接口，通过调用所配置路径转发至各微服务接口
- 安全 权限校验
- 服务迁移 简单化因业务变化而需要拆分/整合服务的工作

mvn clean package docker:build -DskipTests

docker images

docker run -p 1100:1100 service-gateway

