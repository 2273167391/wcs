package com.zhanhong.wcs.tools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class CustomDateTimeSerialize extends JsonSerializer<Date>{
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(Date value, JsonGenerator json, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		json.writeString(sdf.format(value));
	}

}
