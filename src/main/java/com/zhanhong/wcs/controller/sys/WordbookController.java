package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhanhong.wcs.entity.sys.WcsSysWordBook;
import com.zhanhong.wcs.service.WordBookService;

/**
 * 数据字典控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/wordbook")
public class WordbookController {
	
	@Autowired
	private WordBookService wordBookService;
	
	/**
	 * 获取字典类别
	 * @return
	 */
	@RequestMapping(value="/type")
	@ResponseBody
	public List<WcsSysWordBook> queryWordbookType(){
		return wordBookService.queryWordbookType();
	}
	
	/**
	 * 获取数据字典
	 * @param wordBook
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsSysWordBook> queryWordbook(WcsSysWordBook wordBook){
		return wordBookService.queryWordbook(wordBook);
	}
	
	/**
	 * 保存数据字典
	 * @param action
	 * @param wordBook
	 * @return
	 */
	@RequestMapping(value="/{action}")
	@ResponseBody
	public String saveWordbook(@PathVariable String action,WcsSysWordBook wordBook){
		if("add".equals(action)){
			return wordBookService.addWordBook(wordBook);
		}
		return wordBookService.updateWordBook(wordBook);
	}
	
	/**
	 * 删除数据字典
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/delete/{code}")
	@ResponseBody
	public String deleteWordbook(@PathVariable String code){
		return wordBookService.deleteWordbook(code);
	}
}
