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
	
	@Autowired
	private MyTestJob myTestJob;
	
//
//	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 60)
//	public void subTest() {
//		logger.debug("sub test");
//	}
	
//	@Autowired
//	private SwaggerConfig swaggerConfig;
	
	@Scheduled(initialDelay=1000L * 2, fixedDelay=1000L * 5)
	public void toolTest1() {
		logger.debug("1-" + CommonTool.UUID());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
		}
		myTestJob.startMyJob();
	}
	
	@Scheduled(initialDelay=1000L * 3, fixedDelay=1000L * 5)
	public void toolTest2() {
		logger.debug("2-" + CommonTool.UUID());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
		}
		myTestJob.startMyJob();
	}
	
	@Scheduled(initialDelay=1000L * 4, fixedDelay=1000L * 5)
	public void toolTest3() {
		logger.debug("3-" + CommonTool.UUID());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
		}
		myTestJob.startMyJob();
	}
	
}

