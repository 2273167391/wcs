package com.zhanhong.wcs.controller.use;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.entity.use.WcsUseMagcard;
import com.zhanhong.wcs.service.MagcardService;
import com.zhanhong.wcs.view.use.WcsUseMagcardV;

@Controller
@RequestMapping(value="/use/magcard")
public class MagcardController {
	
	@Autowired
	private MagcardService magcardService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsUseMagcardV> queryMagcardAll(WcsUseMagcardV magcardV){
		return magcardService.queryMagcardVAll(magcardV);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveMagcard(WcsUseMagcard magcard){
		return magcardService.addMagcard(magcard);
	}
	
	/**
	 * 充值磁卡
	 * @param rechargeNotes
	 * @return
	 */
	@RequestMapping(value="/recharge")
	@ResponseBody
	public String rechargeMagcard(WcsCostRechargeNotes rechargeNotes){
		return magcardService.updateRechargeMagcard(rechargeNotes);
	}
	
	/**
	 * 注销磁卡
	 * @param magcardId
	 * @return
	 */
	@RequestMapping(value="/cancel/{magcardId}")
	@ResponseBody
	public String cancelMagcard(@PathVariable int magcardId){
		return magcardService.cancelMagcard(magcardId);
	}
	
	/**
	 * 删除磁卡
	 * @param magcardId
	 * @return
	 */
	@RequestMapping(value="/delete/{magcardId}")
	@ResponseBody
	public String deleteMagcard(@PathVariable int magcardId){
		return magcardService.deleteMagcard(magcardId);
	}
}
