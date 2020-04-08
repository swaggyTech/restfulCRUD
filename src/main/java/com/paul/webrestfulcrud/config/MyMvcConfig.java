package com.paul.webrestfulcrud.config;

import com.paul.webrestfulcrud.component.LoginHandlerInterceptor;
import com.paul.webrestfulcrud.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/3 18:02
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 定制嵌入式的Servlet容器的定制器；来修改Servlet容器的配置
     * @return
     */
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        //定制嵌入式servlet容器的相关规则
        return factory -> factory.setPort(8080);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源由springboot做好了静态资源映射
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/assert/**");
    }



    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
