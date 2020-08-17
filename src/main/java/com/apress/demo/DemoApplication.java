package com.apress.demo;

import com.apress.demo.Domain.Datasource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String [] args) {

        //Setting active profiles
//        System.setProperty("spring.profiles.active", "myBatis, production");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
        String [] beanDefinitionNames = context.getBeanDefinitionNames();

        System.out.println("Get all Spring Beans");
        for (String b : beanDefinitionNames){
            System.out.println(b);
        }

        Environment environment = context.getEnvironment();

        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("\nPrint all Active profiles:");
        Arrays.stream(activeProfiles).forEach(activeProfile -> System.out.println("* " + activeProfile));

        String[] defaultProfiles = environment.getDefaultProfiles();
        System.out.println("\nPrint all default profiles:");
        Arrays.stream(defaultProfiles).forEach(defaultProfile -> System.out.println(defaultProfile));

        Datasource ds = context.getBean(Datasource.class);
        System.out.println(ds);
    }
}
