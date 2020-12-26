package com.yuansong.tools.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.deansquirrel.tools.common.CommonTool;
import com.yuansong.tools.demo.job.MyTestJob;

@Component
@EnableScheduling
public class DemoTask {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoTask.class);
	
	private static boolean sFlag = false;
	
	@Autowired
	private MyTestJob myTestJob;
	
//
//	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 60)
//	public void subTest() {
//		logger.debug("sub test");
//	}
	
//	@Autowired
//	private SwaggerConfig swaggerConfig;
	
	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 10)
	public void toolTest() {
		logger.debug("tool test begin");
		logger.debug(CommonTool.UUID());
//		
//		logger.debug(String.valueOf(swaggerConfig.getEnable()));
//		logger.debug(swaggerConfig.getTitle());
//		logger.debug(swaggerConfig.getDescription());
//		logger.debug(swaggerConfig.getVersion());
		if(!sFlag) {
			myTestJob.startThread(500L);
			sFlag = true;
		}
//		
		logger.debug("tool test end");
	}
}

