package ru.stepup.javapro;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class HikaryConnectionPool {

    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/StepUp");
        config.setUsername("postgres");
        config.setPassword("1");
        config.setMaximumPoolSize(4);
        return new HikariDataSource(config);
    }

}
