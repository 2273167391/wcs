package com.zhanhong.wcs.exception;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
/**
 * 全局异常处理类
 * @author Arvin_Li
 *
 */
public class UriWcsExceptionHandler extends RuntimeException {
	// 创建属性对象
	private static Properties pro = new Properties();

	/**
	 * 使用静态代码块加载属性文件
	 */
	static {
		// 加载属性文件
		try {
			pro.load(UriWcsExceptionHandler.class.getClassLoader()
					.getResourceAsStream("exception/exception_info.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UriWcsExceptionHandler(String code) {
		super(pro.getProperty(code));
	}

	public UriWcsExceptionHandler(String code, Object... objects) {
		super(MessageFormat.format(pro.getProperty(code), objects));
	}
}
