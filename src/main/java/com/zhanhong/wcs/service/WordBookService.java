package com.zhanhong.wcs.service;
import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysWordBook;
/**
 * 数据字典服务接口
 * @author Arvin_Li
 *
 */
public interface WordBookService {
	/**
	 * 添加数据字典
	 * @param wordBook 数据字典对象
	 * @return
	 */
	public String addWordBook(WcsSysWordBook wordBook);
	
	/**
	 * 修改数据字典
	 * @param wordBook
	 * @return
	 */
	public String updateWordBook(WcsSysWordBook wordBook);
	
	/**
	 * 获取字典类别
	 * @return
	 */
	public List<WcsSysWordBook> queryWordbookType();
	
	/**
	 * 获取数据字典
	 * @param wordBook
	 * @return
	 */
	public List<WcsSysWordBook> queryWordbook(WcsSysWordBook wordBook);
	
	/**
	 * 删除数据字典
	 * @param wordBookCode
	 * @return
	 */
	public String deleteWordbook(String wordBookCode);
}
