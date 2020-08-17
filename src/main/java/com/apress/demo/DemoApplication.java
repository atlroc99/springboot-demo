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
                                   /* SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);*/

        //make sure to pass the application main class in the constructor
//       SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);

        //customizing the banner:
   /*    builder.bannerMode(Banner.Mode.LOG)
               .sources(DemoApplication.class)
               .run(args);*/

        //customizing the logger info
        // builder.logStartupInfo(true).run(args);


        //adding application event listener
     /*   Logger logger = LoggerFactory.getLogger(DemoApplication.class);
        builder.listeners(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                logger.info("### --> " + event.getClass().getCanonicalName());
            }
        }).run(args);*/

        //Spring-boot guesses what kind of application we are running based on the classpath
//        builder.web(WebApplicationType.NONE).run(args);

        // passing args to the spring application
        //if you run your spring application you have to pass arguments to --<args> and --enabled during the start up
        //-Dspring-boot.run.arguments="args1 args2 arg..n"

//        builder.run(args);


        /** Setting active profiles
        if no profile is specified then default profile will used
         (default) expected Result: Datasource{driverClassName='Development_H2_InMemoryDB', url='mysql:jdbc:localhost:3306/myDevelopment_DB', username='development_admin', password='development_admin_password'}
        **/
        System.setProperty("spring.profiles.active", "myBatis, production");
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
