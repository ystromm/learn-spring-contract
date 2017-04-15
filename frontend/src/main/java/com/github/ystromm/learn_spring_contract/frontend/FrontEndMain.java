package com.github.ystromm.learn_spring_contract.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = FrontEndMain.class)
public class FrontEndMain {

    public static void main(String[] args) {
        SpringApplication.run(FrontEndMain.class, args);
    }
}
