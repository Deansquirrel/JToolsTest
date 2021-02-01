package com.yuansong.tools.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyAsyncJob {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAsyncJob.class);

	@Async
	public void subTest() {
		logger.debug("MyAsyncJob begin");
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("MyAsyncJob end");
	}
	
}
