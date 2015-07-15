package com.zhanhong.wcs.test.tool;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
/**
 * 自定义JSON在反序列化时日期格式
 * @author Arvin_Li
 *
 */
public class CustomDateDeserialize extends JsonDeserializer<Date>{
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonParser json, DeserializationContext context)
			throws IOException, JsonProcessingException {
		Date date=null;
		try {
			date=sdf.parse(json.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
