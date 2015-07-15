package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysWordBook;
import com.zhanhong.wcs.mapper.WordBookMapper;
import com.zhanhong.wcs.service.WordBookService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
@Service
public class WordBookServiceImpl extends BaseCommon implements WordBookService{
	
	@Autowired
	private WordBookMapper wordBookMapper;

	@Override
	public String addWordBook(WcsSysWordBook wordBook) {
		wordBook.setWordBookCode(wordBook.getWordBookCode().toUpperCase());
		wordBook.setWordBookTypeCode(wordBook.getWordBookTypeCode().toUpperCase());
		WcsSysWordBook oldWordbook=wordBookMapper.queryWordbookByCode(wordBook.getWordBookCode());
		if(null!=oldWordbook){
			return JsonMessageUtil.errorMessaage("编码【"+wordBook.getWordBookCode()+"】已存在，保存失败");
		}
		this.copyBean(wordBook, true);
		return wordBookMapper.addWordBook(wordBook)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败!");
	}

	@Override
	public List<WcsSysWordBook> queryWordbookType() {
		return wordBookMapper.queryWordbookType();
	}

	@Override
	public List<WcsSysWordBook> queryWordbook(WcsSysWordBook wordBook) {

		if(StringUtil.isEmpty(wordBook.getWordBookCode())){
			wordBook.setWordBookCode("%"+wordBook.getWordBookCode()+"%");
		}
		if(StringUtil.isEmpty(wordBook.getWordBookContent())){
			wordBook.setWordBookContent("%"+wordBook.getWordBookContent()+"%");
		}
		return wordBookMapper.queryWordbook(wordBook);
	}

	@Override
	public String updateWordBook(WcsSysWordBook wordBook) {
		this.copyBean(wordBook, false);
		return wordBookMapper.updateWordBook(wordBook)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败!");
	}

	@Override
	public String deleteWordbook(String wordBookCode) {
		List<WcsSysWordBook> wbList=wordBookMapper.queryWordbookByTypeCode(wordBookCode);
		if(wbList.size()>0){
			return JsonMessageUtil.errorMessaage("字典编码【"+wordBookCode+"】已经被其他字典做为类别在使用，不能删除！");
		}
		return wordBookMapper.deleteWordbook(wordBookCode)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败!");
	}

}
