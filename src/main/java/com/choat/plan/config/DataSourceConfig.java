package com.choat.plan.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Bean("postgres")
    @ConfigurationProperties(prefix = "spring.datasource.druid.postgres")
    public DataSource postgresDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("mysql")
    @ConfigurationProperties(prefix = "spring.datasource.druid.mysql")
    public DataSource mysqlDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
