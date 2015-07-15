package com.zhanhong.wcs.mapper;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysWordBook;

/**
 * 数据字典
 * @author Arvin_Li
 *
 */
public interface WordBookMapper {
	/**
	 * 添加数据字典
	 * @param wordBook 数据字典对象
	 * @return
	 */
	public int addWordBook(WcsSysWordBook wordBook);
	
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
	 * 根据编码查询数据字典
	 * @param wordbookCode
	 * @return
	 */
	public WcsSysWordBook queryWordbookByCode(String wordbookCode);
	
	/**
	 * 修改数据字典
	 * @param wordBook
	 * @return
	 */
	public int updateWordBook(WcsSysWordBook wordBook);
	
	/**
	 * 删除数据字典
	 * @param wordBookCode
	 * @return
	 */
	public int deleteWordbook(String wordBookCode);
	
	/**
	 * 根据类别编码查询字典
	 * @param wordBookTypeCode
	 * @return
	 */
	public List<WcsSysWordBook> queryWordbookByTypeCode(String wordBookTypeCode);
	
	
}
