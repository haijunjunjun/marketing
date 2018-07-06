package com.example.demo.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by haijun on 2018/7/3.
 */
@Configuration
public class DatasourceConfig {


    @Bean("datasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.readwrite")
    public DataSourceProperties getDataSource() {
        return new DataSourceProperties();
    }

    @Bean("readDatasource")
    @Qualifier("datasource")
    @Primary
    public DataSource readDatasource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
