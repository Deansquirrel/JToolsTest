package com.yuansong.tools.demo.config;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ShutdownConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ShutdownConfig.class);
	
	@PreDestroy  
	public void preDestroy() {
		logger.warn("Shutting down");
	}

}
