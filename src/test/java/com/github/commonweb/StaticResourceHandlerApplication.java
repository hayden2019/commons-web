package com.github.commonweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@EnableAutoConfiguration
@ServletComponentScan
public class StaticResourceHandlerApplication  {

    /**
     * Run this file with argument: --spring.config.location=classpath:/application-static-resource.yml
     * https://docs.spring.io/spring-boot/docs/1.5.20.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-static-contenta
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(StaticResourceHandlerApplication.class);
        ApplicationContext context = springApplication.run(args);
    }

    @Order(1)
   //重点
    @WebFilter(filterName = "testFilter1", urlPatterns = "/*")
    public static class TestFilterFirst implements Filter {
        @Autowired
        User user;
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println(user);
        }

        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                throws IOException, ServletException {
            System.out.println("TestFilter1");
            System.out.println(user);
            filterChain.doFilter(servletRequest,servletResponse);
        }
        public void destroy() {

        }
    }

    @Component
    public static class User{
         String id = "100";
    }

}
