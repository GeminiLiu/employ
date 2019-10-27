package db.multi.secondary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据源配置
 * @author gotanks
 */
@Configuration
public class SecondaryDataSourceConfig {

    @Bean(name="secondaryDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource-secondary")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="secondaryHikariConfig")
    @ConfigurationProperties(prefix="spring.datasource-secondary.hikari")
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        DataSourceProperties dataSourceProperties = dataSourceProperties();
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dataSourceProperties.getUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        return hikariConfig;
    }

    @Bean(name="secondaryDataSource")
    @Qualifier("secondaryDataSource")
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
//        return dataSourceProperties().initializeDataSourceBuilder().build();
    }
}