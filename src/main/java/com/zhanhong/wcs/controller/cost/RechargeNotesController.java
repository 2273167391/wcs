package com.zhanhong.wcs.controller.cost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.service.RechargeNotesService;
import com.zhanhong.wcs.view.cost.WcsCostRechargeNotesV;

@Controller
@RequestMapping(value="/cost/recharge_notes")
public class RechargeNotesController {
	@Autowired
	private RechargeNotesService rechargeNotesService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsCostRechargeNotesV> queryRechargeNotesAll(WcsCostRechargeNotesV rechargeNotesV){
		return rechargeNotesService.queryRechargeNotesAll(rechargeNotesV);
	}
	
	@RequestMapping(value="/{magcardId}/{isExpend}")
	@ResponseBody
	public List<WcsCostRechargeNotesV> queryRechargeNotesByUserId(@PathVariable int magcardId,@PathVariable int isExpend){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("magcardId", magcardId);
		map.put("isExpend", isExpend);
		return rechargeNotesService.queryRechargeNotesByMagcardId(map);
	}
	
	/**
	 * 删除记录
	 * @param notesId
	 * @return
	 */
	@RequestMapping(value="/delete/{notesId}")
	@ResponseBody
	public String deleteNotes(@PathVariable int notesId){
		return rechargeNotesService.deleteRechargeNotes(notesId);
	}
}
