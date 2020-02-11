package com.revature;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@EnableWebMvc // XML equivalent: <mvc:annotation-driven/>
@ComponentScan
@Configuration
public class AppConfig  implements WebMvcConfigurer, WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // create an IOC container for the web app and register this config class

        AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
        container.register(AppConfig.class);

        // add our context loader listener to  the provided ServletContext
        servletContext.addListener(new ContextLoaderListener(container));

        //dynamically register the dispatcher servlet to the provided ServletContext
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(container)); //pass in the container

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
