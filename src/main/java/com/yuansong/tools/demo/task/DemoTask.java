package com.yuansong.tools.demo.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DemoTask {
	
//	private static final Logger logger = LoggerFactory.getLogger(DemoTask.class);
	
//
//	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 60)
//	public void subTest() {
//		logger.debug("sub test");
//	}
	
//	@Autowired
//	private SwaggerConfig swaggerConfig;
	
	@Scheduled(initialDelay=1000L * 5, fixedDelay=1000L * 5 * 60)
	public void toolTest() {
//		logger.debug("tool test begin");
//		
//		logger.debug(String.valueOf(swaggerConfig.getEnable()));
//		logger.debug(swaggerConfig.getTitle());
//		logger.debug(swaggerConfig.getDescription());
//		logger.debug(swaggerConfig.getVersion());
//		
//		logger.debug("tool test end");
	}
	
	
}

