package com.zhanhong.wcs.test.cost;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.service.RechargeNotesService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class RechargeNotesTest extends BasicTest{
	
	@Autowired
	private RechargeNotesService rechargeNotesService;
	
	@Test
	public void testAddRechargeNotes(){
		WcsCostRechargeNotes rechargeNotes=new WcsCostRechargeNotes();
		rechargeNotes.setRechargeMoney(100.0);
		rechargeNotes.setCreationBy(1);
		System.out.println(rechargeNotesService.addRechargeNotes(rechargeNotes, "USM1433139024348"));
	}
}
