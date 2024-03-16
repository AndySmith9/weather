# weather
本项目由天气服务(weather3),天气数据服务(WeatherSourceServer),城市数据服务(WeatherCityServer)这三个服务组成，      
以上三个服务在Eureka上注册,天气服务使用openfeign调用天气数据服务和城市数据服务.      
天气数据服务:根据城市编码查询天气数据.使用jackson将json格式的天气数据文件转换成List<WeatherDto>.    
城市数据服务:根据城市名字查询城市编码.使用jackson将json格式的城市数据文件转换成List<CitycodeDto>.   
天气服务:根据城市名字查询城市天气数据.使用Quartz定时将天气数据缓存到Redis里.        

Eureka使用        
服务器端:    
1.添加依赖:spring-cloud-starter-netflix-eureka-server    
2.application.yml文件新增    
eureka:   
  client:   
    service-url:   
      defaultZone: http://localhost:${server.port}/eureka/   
    register-with-eureka: false   
    fetch-registry: false   
3.启动类上添加注解@EnableEurekaServer  
客户端:   
1.添加依赖:spring-cloud-starter-netflix-eureka-client   
2.application.yml文件新增    
eureka:   
  instance:   
    prefer-ip-address: true   
    instance-id: ${spring.cloud.client.ip-address}:${server.port}   
  client:    
    service-url:   
      defaultZone: http://localhost:8974/eureka/    

openfeign使用   
服务提供方   
1.添加依赖spring-cloud-starter-openfeign    
2.创建服务方法接口项目,在接口上上使用注解@FeignClient(name="注册服务名")     
服务调用方   
1.添加依赖spring-cloud-starter-openfeign,服务方法接口项目
2.在启动类上添加注解@EnableFeignClients(basePackages={"服务方法接口包名1","服务方法接口包名2"})   








