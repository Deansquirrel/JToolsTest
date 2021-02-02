package com.yuansong.tools.demo.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
		
	@ApiOperation(value="root")
	@RequestMapping(value = "/root",method = RequestMethod.POST)
	public String getRoot() {
	
	
		return "root";
	}
		
	@ApiOperation(value = "body")
	@RequestMapping(value = "/action",method = RequestMethod.POST)
	public String getBody(@RequestBody String body) {
		logger.debug(body);
		return body;
	}

}
