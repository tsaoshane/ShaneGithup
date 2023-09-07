package bbsWs.handler;

import java.util.Date;

public class RequestDto {
	private Date msgInDate;
	private String msgStr; //hex String
	
	public Date getMsgInDate()
	{
		return msgInDate;
	}
	public void setMsgInDate(Date msgInDate)
	{
		this.msgInDate = msgInDate;
	}
	public String getMsgStr()
	{
		return msgStr;
	}
	public void setMsgStr(String msgStr)
	{
		this.msgStr = msgStr;
	}	
}
