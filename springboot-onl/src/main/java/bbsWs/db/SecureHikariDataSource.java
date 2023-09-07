package bbsWs.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConfigurationPropertiesScan
@Configuration
public class SecureHikariDataSource {
	
	private static HikariDataSource txnDataSource;
	private static HikariDataSource txnIoDataSource;

	public HikariDataSource getTxnDateSorce()
	{
		return txnDataSource;
	}
	
	public HikariDataSource getTxnIoDateSorce()
	{
		return txnIoDataSource;
	}
	
	@Bean
	@Primary
	@ConfigurationProperties("datasource.txn")
	public DataSourceProperties txnDataSourceProperties() {
		return new DataSourceProperties();
	}
	
//	@Bean
//	@ConfigurationProperties("datasource.txnio")
//	public DataSource txnIoDataSourceProperties() {
//		return new DataSource();
//	}

	
//	@Bean
//	@Primary
//	@ConfigurationProperties("datasource.configuration")
//	public HikariDataSource loadTxnDataSource() throws SQLException {
//		//log.info("loadTxnDataSource url:{}", txnDataSourceProperties().getUrl());
//		txnDataSource = txnDataSourceProperties().initializeDataSourceBuilder()
//				.type(HikariDataSource.class).build();
//		log.info("txnDataSource url:{}", txnDataSource.getMaximumPoolSize());
//		log.info("txnDataSource url:{}", txnDataSource.getMinimumIdle());
//		return txnDataSource;
//	}
	
//
//	@Bean
//	@ConfigurationProperties("datasource.hircommand")
//	public void loadTxnIoDataSource() {
//		//log.info("loadTxnIoDataSource url:{}", txnIoDataSourceProperties().getUrl());
//		txnIoDataSource = txnIoDataSourceProperties().initializeDataSourceBuilder()
//				.type(HikariDataSource.class).build();
//	}
}
