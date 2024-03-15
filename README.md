# weather
本项目由天气服务(weather3),天气数据服务(WeatherSourceServer),城市数据服务(WeatherCityServer)这三个服务组成，
以上三个服务在Eureka上注册,天气服务使用openfeign调用天气数据服务和城市数据服务.
天气数据服务:根据城市编码查询天气数据.使用jackson将json格式的天气数据文件转换成List<WeatherDto>.
城市数据服务:根据城市名字查询城市编码.使用jackson将json格式的城市数据文件转换成List<CitycodeDto>.
天气服务:根据城市名字查询城市天气数据.使用Quartz定时将天气数据缓存到Redis里.










