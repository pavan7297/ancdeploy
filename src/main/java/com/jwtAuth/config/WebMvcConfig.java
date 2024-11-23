package com.jwtAuth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.jwtAuth.interceptors.CommonDataInterceptor;



public class WebMvcConfig extends WebMvcConfigurationSupport {

	private final WebRequestInterceptor requestInterceptor;

    @Autowired
    public WebMvcConfig(WebRequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonDataInterceptor(requestInterceptor));
        // You can add more interceptors here if needed.
    }
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedMethods("GET", "POST");
//	}
}

