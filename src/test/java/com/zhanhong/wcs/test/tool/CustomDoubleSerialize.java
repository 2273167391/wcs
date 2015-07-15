package com.zhanhong.wcs.test.tool;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 * 自定义JSON在序列化是Double的格式
 * @author Arvin_Li
 *
 */
public class CustomDoubleSerialize extends JsonSerializer<Double>{
	private DecimalFormat df=new DecimalFormat("##.00");

	@Override
	public void serialize(Double value, JsonGenerator json,
			SerializerProvider sp) throws IOException,
			JsonProcessingException {
		json.writeString(df.format(value));
	}

	

}
