package com.apress.demo.Domain;

import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Profile({"myBatis"})
public class MyBatisDaoImpl implements MyDAO {
    @Override
    public List<String> getNames() {
        return Arrays.asList("MyBatis Name 1", " MyBatis name 2", " MyBatis name3");
    }
}
