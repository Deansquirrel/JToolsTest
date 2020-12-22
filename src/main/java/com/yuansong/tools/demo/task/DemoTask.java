package com.yuansong.tools.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yuansong.tools.common.MathTool;

@Component
@EnableScheduling
public class DemoTask {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoTask.class);
	
//
//	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 60)
//	public void subTest() {
//		logger.debug("sub test");
//	}
	
	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 5)
	public void toolTest() {
		logger.debug("tool test begin");
		int f = 0;
		do {
			logger.debug(String.valueOf(MathTool.RandInt(5, 7)));
			f++;
		}while(f < 10);
		logger.debug("tool test end");
	}
	
	
}
