package com.apress.demo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Profile({"hibernate" , "default"})
@Repository
public class HibernateDaoImpl implements MyDAO {

    @Autowired
    private Datasource datasource;

    @Autowired
    public HibernateDaoImpl(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<String> getNames() {
        return Arrays.asList("hibernate Name 1", "hibername name 2", " hibernate name3");
    }

    @Override
    public void printDataSourceInfo() {
        System.out.println(datasource);
    }

}
