package com.eproducts.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DBConnections {
    
    public DriverManagerDataSource connect(){
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_8cae3f49ed4297d?user=b43609b9d681b5&password=b361e96c");
        dataSource.setUsername("b43609b9d681b5");
        dataSource.setPassword("b361e96c");
        return dataSource;
    }
    
}