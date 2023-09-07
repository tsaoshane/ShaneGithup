package bbsWs.handler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.jpos.iso.ISOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MessageDecodeHandler extends MessageToMessageDecoder<ByteBuf>
{
	private static final Logger log = LoggerFactory.getLogger(MessageDecodeHandler.class);
	
	public MessageDecodeHandler()
	{
		
	}

	protected void decode(ChannelHandlerContext ctx, ByteBuf msgBuf, List<Object> out) throws Exception
	{	
		ByteBufInputStream bbis = null;
		Date nowDate = new Date();
		try
		{
			if(null != msgBuf)
			{	
				//log.debug("msg capacity : " + msgBuf.capacity());
				
				bbis = new ByteBufInputStream(msgBuf);			
				byte[] msgArray = readStream(bbis);
				
				RequestDto info = new RequestDto();
				info.setMsgInDate(nowDate);
				info.setMsgStr(ISOUtil.hexString(msgArray));
				
				out.add(info);
				//log.debug("msg length : " + ((null == msgArray)?0:msgArray.length));
			}
			else
			{
				log.warn("[{}]msg is null !!!!!!", ctx.channel().id());
			}
		}
		finally
		{
			if(null != bbis)
			{
				bbis.close();
			}
		}
	}
	
	public static byte[] readStream(InputStream inStream) throws Exception 
	{
		ByteArrayOutputStream outStream = null;
		
		try
		{
			outStream = new ByteArrayOutputStream();  
			byte[] buffer = new byte[4096];  
			int len = -1;  
			while ((len = inStream.read(buffer)) != -1) 
			{  
				outStream.write(buffer, 0, len);  
			}  
			byte[] retArray = outStream.toByteArray();
			return retArray;
		}
		finally
		{
			if(null != outStream)
			{
				outStream.close(); 
			}
		}
    }
}