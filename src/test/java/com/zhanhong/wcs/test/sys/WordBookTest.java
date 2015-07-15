package com.zhanhong.wcs.test.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.zhanhong.wcs.entity.sys.WcsSysWordBook;
import com.zhanhong.wcs.service.BaseCommonService;
import com.zhanhong.wcs.service.WordBookService;
import com.zhanhong.wcs.test.basic.BasicTest;


public class WordBookTest extends BasicTest{
	
	@Autowired
	private WordBookService wordBookService;
	
	@Autowired
	private BaseCommonService baseCommonService;
	
	@Test
	public void testAddWordBook(){
		for(int i=6;i<10;i++){
			//创建数据字典
			WcsSysWordBook wordBook=new WcsSysWordBook();
			wordBook.setWordBookCode("W00"+i);
			wordBook.setWordBookTypeCode("");
			wordBook.setWordBookContent("预留"+i);
			wordBook.setEffectiveDate(new Date());
			wordBook.setVersion(1);
			wordBook.setCreationBy(2);
			wordBook.setCreationDate(new Date());
			System.out.println(wordBookService.addWordBook(wordBook));
		}
	}
	
	@Test
	public void testQueryWordBook(){
		List<Map<String, String>> list=baseCommonService.queryWordBookByCode("W001");
		System.out.println(JSONObject.toJSONString(list));
	}
}
