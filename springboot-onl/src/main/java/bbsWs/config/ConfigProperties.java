package bbsWs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="netty")
@ConfigurationPropertiesScan
@Configuration
public class ConfigProperties {
	private String hostIp;
	private Integer port;
	private Integer bossThread;
	private Integer workThread;
	private Integer timeout;
}