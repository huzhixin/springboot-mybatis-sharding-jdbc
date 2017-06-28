package com.cto001.qnzsopen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cto001.qnzsopen.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QnzsopenApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(QnzsopenApplication.class, args);
//	}
    public static void main(final String[] args) {
        // CHECKSTYLE:ON
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/mybatisContext.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.clear();
        orderService.fooService();
        orderService.select();

        //[order_id: , user_id: 10, status: UPDATED, order_id: , user_id: 11, status: UPDATED]
//        orderService.clear();
//        try {
//            orderService.fooServiceWithFailure();
//        } catch (final IllegalArgumentException e) {
//            System.out.println("roll back");
//        }
        //[]
        orderService.select();
    }
}
