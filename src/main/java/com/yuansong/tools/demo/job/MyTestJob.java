package com.yuansong.tools.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.github.deansquirrel.tools.common.CommonTool;

@Component
public class MyTestJob{
	
	private static final Logger logger = LoggerFactory.getLogger(MyTestJob.class);

	@Async("taskExecutor")
	public void startMyJob() {
		logger.debug("myjob-" + CommonTool.UUID());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
		}
	}
}
