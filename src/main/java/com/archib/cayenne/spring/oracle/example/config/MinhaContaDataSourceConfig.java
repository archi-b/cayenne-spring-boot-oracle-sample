/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archib.cayenne.spring.oracle.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 *
 * @author mp26087
 */
@Configuration
@EnableTransactionManagement
public class MinhaContaDataSourceConfig {

    private DataSource minhacontaDataSource;

    @Primary
    @ConfigurationProperties("minha-conta.datasource")
    @Bean(name = "minhaContaDataSource")
    public DataSource minhaContaDataSource() {
        if (minhacontaDataSource == null) {
            minhacontaDataSource = DataSourceBuilder.create().build();
        }
        return minhacontaDataSource;
    }

}