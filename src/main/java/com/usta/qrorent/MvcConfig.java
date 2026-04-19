//package com.usta.qrorent;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Mapea /css/**, /js/**, /images/** a la carpeta static/
//        registry
//                .addResourceHandler("/css/**")
//                .addResourceLocations("classpath:/static/css/");
//
//        registry
//                .addResourceHandler("/js/**")
//                .addResourceLocations("classpath:/static/js/");
//
//        registry
//                .addResourceHandler("/images/**")
//                .addResourceLocations("classpath:/static/images/");
//    }
//}