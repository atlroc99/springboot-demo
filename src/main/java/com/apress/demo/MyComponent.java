package com.apress.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyComponent {

    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);

    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enabled = args.containsOption("enable");
        if (enabled) {
            log.info("## > " + "You are enabled: " + enabled + "!");
            List<String> _args = args.getNonOptionArgs();
            if (!_args.isEmpty()) {
                _args.forEach(file -> log.info(file));
            }

        }
    }
}
