package com.yuansong.tools.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yuansong.tools.task.IDynamicTaskManager;

@Component
public class StartTask implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(StartTask.class);
		
	@Autowired
	private IDynamicTaskManager dynamicTaskManager;

	@Override
	public void run(String... args) throws Exception {
		

	}
	
//	private void printS() {
//		for(String name : dynamicTaskManager.getTaskList()) {
//			logger.debug(MessageFormat.format("task {0} {1} {2} {3}", 
//					name, 
//					dynamicTaskManager.isRunning(name),
//					dynamicTaskManager.isStarted(name),
//					dynamicTaskManager.containTask(name)
//					));
//			
//		}
//	}

}
