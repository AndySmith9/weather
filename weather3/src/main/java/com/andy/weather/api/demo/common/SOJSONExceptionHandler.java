package com.andy.weather.api.demo.common;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@ControllerAdvice
@Component
public class SOJSONExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {


            String message = e.getMessage();
            if("no_city_id".equalsIgnoreCase(message)){
                message = "CityId不在返回之内,加QQ群：608222884，验证消息 sojson api，反馈问题。";          
            }
JsonData jsonData = JsonData.fail(message);
MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        return new ModelAndView(jsonView,jsonData.toMap());
    }
}
