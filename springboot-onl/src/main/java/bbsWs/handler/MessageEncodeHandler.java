package bbsWs.handler;

import org.jpos.iso.ISOUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncodeHandler extends MessageToByteEncoder<String> {
	
    public MessageEncodeHandler() {

    }

    @Override
	protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception 
	{
		out.writeBytes(ISOUtil.hex2byte(msg));
	}
}