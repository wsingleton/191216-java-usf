package com.lynda.common;

import com.lynda.common.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
        OrderService orderService = context.getBean(OrderService.class);
    }
}
