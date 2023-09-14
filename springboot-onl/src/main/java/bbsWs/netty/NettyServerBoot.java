package bbsWs.netty;

import java.net.SocketAddress;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

import bbsWs.config.ConfigProperties;
import bbsWs.db.SecureHikariDataSource;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NettyServerBoot {

	@Autowired
	ConfigProperties nettyProperties;
	
	@Autowired
	ServerBootstrap serverBootstrap;
	
	@Resource
    NioEventLoopGroup boosGroup;
	
    @Resource
    NioEventLoopGroup workerGroup;
    
    SocketAddress socketAddress = null;   
	
	@PostConstruct
    public void start() throws InterruptedException {
		/*
		try {
			ChannelFuture future = serverBootstrap.bind(nettyProperties.getPort()).sync();
	        socketAddress = future.channel().localAddress();
	        log.info("Start Netty Listen : {}", socketAddress.toString());
		} catch (Throwable t) {
    		log.error("", t);
    		throw t;
    	}
		*/
    }

    @PreDestroy
    public void close() {
    	/*
    	try {
	    	if(null != boosGroup && !boosGroup.isShutdown()) {
	    		boosGroup.shutdownGracefully();
	    	}
	    	
	    	if(null != workerGroup && !workerGroup.isShutdown()) {
	    		workerGroup.shutdownGracefully();
	    	}
    	} catch (Throwable t) {
    		log.error("", t);
    	} finally {
    		log.info("Shutdown Netty Listen : {}", socketAddress.toString());
    	}
		*/
    }
}
