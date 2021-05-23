package com.yuansong.tools.demo.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags={"根路径"})
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
		
	@ApiIgnore
	@ApiOperation(value="root")
	@RequestMapping(value = "/root",method = RequestMethod.POST)
	public String getRoot() {
		logger.debug("root");
		return "root";
	}

}
