package com.zhanhong.wcs.exception;
/**
 * 系统异常处理类
 * @author Arvin_Li
 *
 */
public class WcsSysExceptionHandler extends RuntimeException{

	public WcsSysExceptionHandler() {
		super();
	}

	public WcsSysExceptionHandler(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WcsSysExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	public WcsSysExceptionHandler(String message) {
		super(message);
	}

	public WcsSysExceptionHandler(Throwable cause) {
		super(cause);
	}

}
