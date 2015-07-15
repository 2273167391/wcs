package com.zhanhong.wcs.test.json;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhanhong.wcs.test.entity.Person;

public class JsonTest {
	public static void main(String[] args) {
		Person p=new Person("admin", "admin", "男", new Date(), 234.8888);
		ObjectMapper mapper=new ObjectMapper();

			System.out.println(JSONObject.toJSON(p));

	}
}
