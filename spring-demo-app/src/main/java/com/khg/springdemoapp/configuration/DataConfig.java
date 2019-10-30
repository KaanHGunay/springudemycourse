package com.khg.springdemoapp.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource("classpath:application.properties")
public class DataConfig {
    @Value("#{environment.dbDriver}")
    private String dbDriver;

    @Value("#{environment.dbUrl}")
    private String dbUrl;

    @Value("#{environment.dbUsername}")
    private String dbUsername;

    @Value("#{environment.dbPassword}")
    private String dbPassword;

    @Bean
    @Profile(Profiles.PRODUCTION)
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(dbDriver);
        ds.setUrl(dbUrl);
        ds.setUsername(dbUsername);
        ds.setPassword(dbPassword);

        return ds;
    }

    @Bean(destroyMethod = "shutdown")
    @Profile(Profiles.DEV)
    public EmbeddedDatabase dataSourceH2() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}
