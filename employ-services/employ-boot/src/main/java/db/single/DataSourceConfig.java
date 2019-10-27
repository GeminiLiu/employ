package db.single;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 数据源配置
 * @author gotanks
 */
@Configuration
@EnableJpaRepositories(basePackages = {"**.repository"})
@EntityScan(basePackages = {"**.entity"})
public class DataSourceConfig {
}