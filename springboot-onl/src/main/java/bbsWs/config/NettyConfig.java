package bbsWs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bbsWs.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class NettyConfig {
	
	@Autowired
	ConfigProperties nettyProperties;
	
    @Bean
    public NioEventLoopGroup boosGroup() {
        return new NioEventLoopGroup(nettyProperties.getBossThread());
    }
    
    @Bean
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(nettyProperties.getWorkThread());
    }
    
    @Bean
    public ServerBootstrap serverBootstrap() {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
        		 .group(boosGroup(), workerGroup())
                 .channel(NioServerSocketChannel.class)
                 .childHandler(new NettyServerHandler())
                 .option(ChannelOption.SO_BACKLOG, 1024)
                 .childOption(ChannelOption.SO_RCVBUF, 4096)
                 .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(4096))
                 .childOption(ChannelOption.SO_KEEPALIVE, true);
        log.info(serverBootstrap.toString());
        return serverBootstrap;
    }
}
