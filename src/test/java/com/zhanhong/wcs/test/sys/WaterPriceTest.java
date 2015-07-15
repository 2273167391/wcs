package com.zhanhong.wcs.test.sys;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;
import com.zhanhong.wcs.service.WaterPriceService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class WaterPriceTest extends BasicTest{
	
	@Autowired
	private WaterPriceService waterPriceService;
	
	@Test
	public void testAddWaterPrice(){
		WcsSysWaterPrice waterPrice=new WcsSysWaterPrice();
		waterPrice.setPriceType("W004001");
		waterPrice.setPrice(3.5);
		waterPrice.setLadderStartMeasure(0.0);
		waterPrice.setLadderEndMeasure(30.0);
		waterPrice.setVersion(1);
		waterPrice.setCreationBy(1);
		waterPrice.setCreationDate(new Date());
		System.out.println(waterPriceService.addWaterPrice(waterPrice));
	}

	
	@Test
	public void testDeleteWaterPrice(){
		System.out.println(waterPriceService.deleteWaterPrice(4));
	}
}
