package com.apress.demo.Domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ImportResource("classpath:META-INF/spring/applicationContext.xml")
public class Datasource {
    @Value("#{dbProps.driverClassName}")
    private String driverClassName;

    @Value("#{dbProps.url}")
    private String url;
    @Value("#{dbProps.username}")
    private String username;

    @Value("#{dbProps.password}")
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
