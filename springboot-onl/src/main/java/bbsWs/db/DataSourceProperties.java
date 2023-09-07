package bbsWs.db;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

//@Data
//@Configuration
//@ConfigurationProperties(prefix = "dynamic-db")
public class DataSourceProperties {
	private Map<String, HikariDataSource> datasources;
    private String defaultDsKey;
}
