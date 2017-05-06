package org.fage.cfg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Fapha
 * @date 2017年4月7日下午9:28:28
 * @version v1.0.1
 * <p>Title: </p> 
 * <p>Description: 全局异常信息捕获</p>
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String defaultExceptionHandler(HttpServletRequest request,Exception e){
		return e.getMessage();
	}

}
