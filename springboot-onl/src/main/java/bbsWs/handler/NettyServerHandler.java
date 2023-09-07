package bbsWs.handler;

import java.util.concurrent.ExecutorService;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler extends ChannelInitializer<SocketChannel>
{
	//private static final org.slf4j.Logger log = LoggerFactory.getLogger(NettyServerHandler.class);
	
	private SSLContext sslctx;
	private boolean isNeedClientAuth = false;
	ExecutorService cachedThreadPool;

    @Override
    public void initChannel(SocketChannel ch) throws Exception 
	{
    	ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MessageDecodeHandler());
        pipeline.addLast(new MessageEncodeHandler());
        if(null != sslctx) {
            SSLEngine engine = sslctx.createSSLEngine();
            engine.setUseClientMode(false);
            engine.setNeedClientAuth(isNeedClientAuth);//是否雙向驗證
            pipeline.addFirst("ssl", new SslHandler(engine));
            log.info("start ssl mode");
        }
//        
        ServerListenerHandler txnHandler = new ServerListenerHandler();
//        txnHandler.setChannelHeader(channelHeader);
//        txnHandler.setCtxListener(ctxListener);
//        txnHandler.setPkger(pkger);
//        txnHandler.setIoLogger(ioLogger);
//        txnHandler.setServerChannel(serverChannel);
//        txnHandler.setProcessTimeout(processTimeout);
//        txnHandler.setCachedThreadPool(cachedThreadPool);
        
        pipeline.addLast(txnHandler);
        log.debug("[{}][Connected][local: {} remote: {}]", ch.id(), ch.localAddress() , ch.remoteAddress());
    }
//
//	public IHeader getChannelHeader()
//	{
//		return channelHeader;
//	}
//
//	public void setChannelHeader(IHeader channelHeader)
//	{
//		this.channelHeader = channelHeader;
//	}
//
//	public IContextListener getCtxListener()
//	{
//		return ctxListener;
//	}
//
//	public void setCtxListener(IContextListener ctxListener)
//	{
//		this.ctxListener = ctxListener;
//	}
//
//	public Packager getPkger()
//	{
//		return pkger;
//	}
//
//	public void setPkger(Packager pkger)
//	{
//		this.pkger = pkger;
//	}
//
//	public IOLogger getIoLogger()
//	{
//		return ioLogger;
//	}
//
//	public void setIoLogger(IOLogger ioLogger)
//	{
//		this.ioLogger = ioLogger;
//	}
//	
//	/**
//     * @return the clientChannel
//     */
//    public NettyServerChannel getServerChannel()
//    {
//        return serverChannel;
//    }
//
//    /**
//     * @param clientChannel the clientChannel to set
//     */
//    public void setServerChannel(NettyServerChannel serverChannel)
//    {
//        this.serverChannel = serverChannel;
//    }
//    
//    /**
//     * @return the sslctx
//     */
//    public SSLContext getSslctx()
//    {
//        return sslctx;
//    }
//
//    /**
//     * @param sslctx the sslctx to set
//     */
//    public void setSslctx(SSLContext sslctx)
//    {
//        this.sslctx = sslctx;
//    }
//    
//    public int getProcessTimeout()
//    {
//        return processTimeout;
//    }
//
//    public void setProcessTimeout(int processTimeout)
//    {
//        this.processTimeout = processTimeout;
//    } 
//    
//    /**
//     * @return the isNeedClientAuth
//     */
//    public boolean getIsNeedClientAuth()
//    {
//        return isNeedClientAuth;
//    }
//
//    /**
//     * @param isNeedClientAuth the isNeedClientAuth to set
//     */
//    public void setNeedClientAuth(boolean isNeedClientAuth)
//    {
//        this.isNeedClientAuth = isNeedClientAuth;
//    }
//    
//    public ExecutorService getCachedThreadPool() {
//		return cachedThreadPool;
//	}
//
//	public void setCachedThreadPool(ExecutorService cachedThreadPool) {
//		this.cachedThreadPool = cachedThreadPool;
//	}
}