获取用户信息 的服务提供者

测试：
启动Eureka注册中心
启动 service-config

Bus RabbitMQ配置刷新
参考：https://segmentfault.com/a/1190000014618581

mvn clean package docker:build -DskipTests

docker images

docker run -p 8761:8761 service-registry

