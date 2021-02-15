package com.application.waterplants.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @Bean(name = "mySqlDataSource")
    @Primary
    public static DataSource mySqlDataSource () {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://storewaterdata.c2sexdihysll.us-east-1.rds.amazonaws.com:3306/STORE_WATER_DATA");
        dataSourceBuilder.username("wateryoudoinhere");
        dataSourceBuilder.password("razmataZ4u");
        return dataSourceBuilder.build();
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplateMySql(@Qualifier("mySqlDataSource")DataSource mySqlDataSource){
        return new JdbcTemplate(mySqlDataSource);
    }

    @Bean
    @Autowired
    public static NamedParameterJdbcTemplate namedmySqlDataSource(){
        return new NamedParameterJdbcTemplate(mySqlDataSource());
    }
}
