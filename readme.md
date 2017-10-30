# ZEN-SC-SAMPLE

## 概述
ZEN-SC-SAMPLE:一组SpringCloud常用组件示例。

## 启动方式
### Docker方式启动
```
mvn clean package
docker-compose up
```
### 手工方式启动
添加DNS
```
vi /etc/hosts
127.0.0.1 zen-eureka
127.0.0.1 zen-zipkin
127.0.0.1 zen-config
```

在每个模块下分别执行
```
mvn spring-boot:run
```

## 组件清单
- hystrix - 服务降级与融断
- feign - 声明式REST调用
- eureka - 服务注册与发现
- ribbon - 客户端负载均衡
- config-server - 配置中心
- zuul - API网关
- turbine - 监控聚合
- hystrix-dashboard - Hystrix面板
- sleuth - 服务跟踪
- zipkin - 调用链跟踪

## 未包含组件
- ELK

## URLs
- [ConfigServer-配置中心](http://localhost:8888/application/default)
- [Eureka-服务注册与发现](http://localhost:8761)
- [Playground-示例微服务](http://localhost:8080/swagger-ui.html)
- [Zuul-应用网关](http://localhost:8040/zen-playground/swagger-ui.html)
- [Turbine-监控聚合](http://localhost:8031/turbine.stream)
- [Zipkin-调用链跟踪](http://localhost:9411/zipkin/)

## 其它说明
### 刷新配置
```
curl -X POST http://localhost:8080/refresh
```
