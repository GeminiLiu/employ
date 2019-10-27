package db.multi.primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 * @author gotanks
 */
@Configuration
public class PrimaryDataSourceConfig {
    @Primary
    @Bean(name="primaryDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="primaryHikariConfig")
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        DataSourceProperties dataSourceProperties = dataSourceProperties();
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dataSourceProperties.getUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        return hikariConfig;
    }

    @Primary
    @Bean(name="primaryDataSource")
    @Qualifier("primaryDataSource")
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
}