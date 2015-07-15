package com.zhanhong.wcs.test.cost;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.cost.WcsCostCopyMeter;
import com.zhanhong.wcs.service.CopyMeterService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class CopyMeterTest extends BasicTest{
	
	@Autowired
	private CopyMeterService copyMeterService;
	
	@Test
	public void testAddCopyMeter(){
		WcsCostCopyMeter copyMeter=new WcsCostCopyMeter();
		copyMeter.setWaterMeterId(1);
		copyMeter.setHandlerDate(new Date());
		copyMeter.setStartNumber(0.0);
		copyMeter.setEndNumber(50.0);
		copyMeter.setDefiniteNumber(copyMeter.getEndNumber()-copyMeter.getStartNumber());
		copyMeter.setWpId(501);
		copyMeter.setEmpId(1);
		copyMeter.setCreationBy(1);
		try {
			System.out.println(copyMeterService.addCopyMeter(copyMeter));
			System.out.println(copyMeter.getCopyMeterId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDeleteCopyMeter(){
		System.out.println(copyMeterService.deleteCopyMeter(2));
	}
	
	
}
