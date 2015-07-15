package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.sys.WcsSysStreet;
import com.zhanhong.wcs.service.StreetService;

/**
 * 街道控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/street")
public class StreetController {
	
	@Autowired
	private StreetService streetService;
	/**
	 * 获取街道信息
	 * @param street
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsSysStreet> queryStreetAll(WcsSysStreet street){
		return streetService.queryStreetAll(street);
	}
	
	/**
	 * 保存街道
	 * @param street
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveStreet(WcsSysStreet street){
		if(null==street.getStreetId()){
			return streetService.addStreet(street);
		}
		return streetService.updateStreet(street);
	}
	
	@RequestMapping(value="/delete/{streetId}")
	@ResponseBody
	public String deleteStreet(@PathVariable int streetId){
		return streetService.deleteStreet(streetId);
	}
}
