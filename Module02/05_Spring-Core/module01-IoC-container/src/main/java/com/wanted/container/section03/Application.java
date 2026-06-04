package com.wanted.container.section03;

import com.wanted.container.section03.config.AppConfig;
import com.wanted.container.section03.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("================싱글톤 스코프 테스트================");

        //getBean(): 컨테이너에 등록된 객체를 꺼낸다.
        PaymentService singlePay = context.getBean("singlePay", PaymentService.class);

        String orderId = "order-001";
        double amount = 15000.0;
        boolean result = singlePay.processPayment(orderId, amount);

        System.out.println("singlePay의 마지막 주문ID: " + singlePay.getLastOrderId());

        PaymentService singlePay2 = context.getBean("singlePay", PaymentService.class);
        System.out.println("singlePay2의 마지막 주문ID: " + singlePay2.getLastOrderId());

        System.out.println("======================================================");

        System.out.println("=================프로토타입 스코프 테스트=================");
        PaymentService protoPay = context.getBean("protoPay", PaymentService.class);

        String orderId2 = "order-001";
        double amount2 = 15000.0;
        boolean result2 = singlePay.processPayment(orderId2, amount2);

        System.out.println("protoPay의 마지막 주문ID: " + protoPay.getLastOrderId());

        PaymentService protoPay2 = context.getBean("protoPay", PaymentService.class);
        System.out.println("protoPay2의 마지막 주문ID: " + protoPay2.getLastOrderId());
    }
}
