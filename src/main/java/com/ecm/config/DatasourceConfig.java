package com.ecm.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
  @Bean
  public DataSource getPostgresqlDataSource() {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.postgresql.Driver");
    dataSourceBuilder.url("jdbc:postgresql://localhost:5432/ecm");
    dataSourceBuilder.username("ecm");
    dataSourceBuilder.password("Ecm!23456");
    return dataSourceBuilder.build();
  }
}
