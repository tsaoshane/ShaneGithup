package bbsWs.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
@Slf4j
public class ServerListenerHandler extends SimpleChannelInboundHandler<Object>
{
	//private static final Logger log = LoggerFactory.getLogger(ServerListenerHandler.class);
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception 
	{
		if(null != ctx && null != ctx.channel())
        {
			log.info("[{}][accept client][local:{} remote: {}]", ctx.channel().id() , ctx.channel().localAddress(), ctx.channel().remoteAddress());
        }
		super.channelActive(ctx);
    }
	
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception 
    {
		if(null != ctx && null != ctx.channel())
    	{
			log.info("[{}][UnConnected client][local:{} remote: {}]", ctx.channel().id() , ctx.channel().localAddress(), ctx.channel().remoteAddress());
    	}
		super.channelInactive(ctx);
    }
	
	@Override
	public void channelRead(ChannelHandlerContext chnHandlerCtx, Object msg) throws Exception
	{
		try {
		    if(null != chnHandlerCtx && null != chnHandlerCtx.channel())
	        {
		    	RequestDto inMsgInfo = (RequestDto)msg;
				
				if(null != inMsgInfo) {		        
					String requestRaw = inMsgInfo.getMsgStr();
					log.info("[{}] Request Raw Data [{}]", chnHandlerCtx.channel().id(), requestRaw);
				}
				
				chnHandlerCtx.channel().writeAndFlush("");
	        }
		} catch (Throwable e) {
			log.error("" , e);
			throw e;
		} finally {
			ReferenceCountUtil.release(msg);
			msg = null;
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) 
    { 
		if (cause instanceof java.io.IOException) {
            log.warn("[{}] client close Connection " , ctx.channel().id());
        } else {
            cause.printStackTrace();
        }
        ctx.close();
    }
}
