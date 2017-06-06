package com.eproducts.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DBConnections {
    
    public DriverManagerDataSource connect(){
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/sys");
        dataSource.setUsername("root");
        dataSource.setPassword("22799281asd");
        return dataSource;
    }
    
}