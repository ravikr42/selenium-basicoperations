package com.ravi.sample;

import java.time.LocalDateTime;

public class Sample {
	
	public static void main(String[] args) {
		
		LocalDateTime time = LocalDateTime.now();
		StringBuilder builder = new StringBuilder();
		builder.append(time.getYear());
		builder.append(time.getMonthValue());
		builder.append(time.getDayOfMonth());
		builder.append("_"+time.getHour()+"_"+time.getMinute()+"_"+time.getSecond());
		
		
		System.out.println(builder.toString());
		
		
		
	}

}
