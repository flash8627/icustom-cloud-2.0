获取用户信息 的服务提供者

测试：
启动Eureka注册中心
启动 server-config
启动 user-service
然后在浏览器输入http://localhost:8801/user/list

依次启动 Eureka Server ---- service-config ---- -user-service

输入：http://localhost:8761/

发现service-user 端口中为8801 由上文可知，该端口的配置是从配置中心读取的

配置文件的名称需要遵守service-user的application.name + 中划线 + profile 约定，否则无法读取

mvn clean package docker:build -DskipTests

docker images

docker run -p 8801:8801 user-service

