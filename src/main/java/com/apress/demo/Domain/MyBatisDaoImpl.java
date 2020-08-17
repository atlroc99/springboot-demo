package com.apress.demo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Profile({"myBatis"})
public class MyBatisDaoImpl implements MyDAO {

    @Autowired
    Datasource datasource;

    @Override
    public List<String> getNames() {
        return Arrays.asList("MyBatis Name 1", " MyBatis name 2", " MyBatis name3");
    }

    @Override
    public void printDataSourceInfo() {
        System.out.println(datasource);
    }
}
