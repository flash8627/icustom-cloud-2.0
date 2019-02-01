服务注册中心

测试：
启动Eureka注册中心
测试地址：http://localhost:8761/

mvn clean package docker:build -DskipTests

docker images

docker run -p 8761:8761 service-registry

