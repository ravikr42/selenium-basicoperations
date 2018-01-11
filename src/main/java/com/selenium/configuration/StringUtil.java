package com.selenium.configuration;

import java.time.LocalDateTime;

public class StringUtil {
	
	public static String getCurrentTimeStamp(){
		LocalDateTime time = LocalDateTime.now();
		StringBuilder builder = new StringBuilder();
		builder.append(time.getYear());
		builder.append(time.getMonthValue());
		builder.append(time.getDayOfMonth());
		builder.append("_"+time.getHour()+"_"+time.getMinute()+"_"+time.getSecond());
		return builder.toString();
	}

}
