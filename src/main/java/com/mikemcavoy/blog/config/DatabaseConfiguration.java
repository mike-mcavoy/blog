package com.mikemcavoy.blog.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public JdbcTemplate jsJdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
