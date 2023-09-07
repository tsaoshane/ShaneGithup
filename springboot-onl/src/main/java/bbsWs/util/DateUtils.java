package bbsWs.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	/** 
     * 获取指定N分钟前/后的时间 
     * @param minute 
     * @return 
     */  
    public static int getDayOfYear(LocalDateTime inDate) {
    	LocalDateTime date = null;
    	if(null == inDate) {
    		date = LocalDateTime.now(ZoneId.of("Asia/Taipei"));
    	} else {
    		date = inDate;
    	}
    	return date.getDayOfYear();
    }
    
    public static String getFormatDate(Date date, String pattern) {
    	Instant now = date.toInstant();
    	ZoneId currentZone = ZoneId.systemDefault();
    	LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
    	return getFormatDate(localDateTime, pattern);
    }
    
    public static String getFormatDate(LocalDate date, String pattern) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	return date.format(formatter);
    } 
    
    public static String getFormatDate(LocalDateTime date, String pattern) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	return date.format(formatter);
    } 
    
    public static int diffDate(String strDate1, String strDate2) {
    	LocalDate date1 = StringToLocalDate(strDate1, "yyyyMMdd");
    	LocalDate date2 = StringToLocalDate(strDate2, "yyyyMMdd");
    	int diffDay = date2.getDayOfYear() - date1.getDayOfYear();
    	return diffDay;
    }
    
    public static long diffMilliSec(LocalDateTime date1, LocalDateTime date2) {   	
    	ZonedDateTime zdt1 = date1.atZone(ZoneId.of("Asia/Taipei"));
    	if(null == date2) {
    		date2 = LocalDateTime.now(ZoneId.of("Asia/Taipei"));
    	}
    	ZonedDateTime zdt2 = date2.atZone(ZoneId.of("Asia/Taipei"));
    	return zdt2.toInstant().toEpochMilli() - zdt1.toInstant().toEpochMilli();
    }
    
    public static long diffMilliSec(String strDate1, String strDate2) {
    	LocalDateTime date1 = StringToLocalDateTime(strDate1, "yyyyMMddHHmmss");
    	LocalDateTime date2 = StringToLocalDateTime(strDate2, "yyyyMMddHHmmss");
    	
    	ZonedDateTime zdt1 = date1.atZone(ZoneId.of("Asia/Taipei"));
    	ZonedDateTime zdt2 = date2.atZone(ZoneId.of("Asia/Taipei"));
    	return zdt1.toInstant().toEpochMilli() - zdt2.toInstant().toEpochMilli();
    }
    
    public static LocalDateTime StringToLocalDateTime(String date, String pattern)
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	return LocalDateTime.parse(date, formatter);
    }
    
    public static LocalDate StringToLocalDate(String date, String pattern)
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	return LocalDate.parse(date, formatter);
    }
}
