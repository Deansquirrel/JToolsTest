package com.yuansong.tools.demo.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.deansquirrel.tools.common.ExceptionTool;

@ControllerAdvice
public class MyExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseResult<?> exceptionHandler(Exception e) {
		logger.error(ExceptionTool.getStackTrace(e));
		return Response.makeErrRsp();
	}
}
