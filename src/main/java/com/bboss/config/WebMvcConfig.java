package com.bboss.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "login" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    } 
    
    /*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new AuthInterceptor());
	}*/
    
    
  /*  @Bean
    public InternalResourceViewResolver viewResolver() {
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        //resolver.setContentType("text/html; charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        return resolver;
    }
    
    */
  /*  @Bean
    public SpringResourceTemplateResolver addThymeleafViewResolver() {
    	SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        //resolver.setContentType("text/html; charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        return resolver;
    }*/
}
