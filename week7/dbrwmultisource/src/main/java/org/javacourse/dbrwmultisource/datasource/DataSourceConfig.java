package org.javacourse.dbrwmultisource.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Autowired
    Environment env;

    @Primary
    @Bean(name = "write")
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("write.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("write.datasource.url"));
        dataSource.setUsername(env.getProperty("write.datasource.username"));
        dataSource.setPassword(env.getProperty("write.datasource.password"));
        return dataSource;

    }

    @Bean(name = "read1")
    public DataSource slave1DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("read1.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("read1.datasource.url"));
        dataSource.setUsername(env.getProperty("read1.datasource.username"));
        dataSource.setPassword(env.getProperty("read1.datasource.password"));
        return dataSource;
    }

    @Bean(name = "read2")
    public DataSource slave2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("read2.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("read2.datasource.url"));
        dataSource.setUsername(env.getProperty("read2.datasource.username"));
        dataSource.setPassword(env.getProperty("read2.datasource.password"));
        return dataSource;
    }
}
