package com.yuansong.tools.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) { 
//		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

        taskScheduler.setThreadNamePrefix("aaaa-");
        taskScheduler.setPoolSize(5);//定义线程池数量为5 个
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.setAwaitTerminationSeconds(5);
        taskScheduler.initialize();
		taskRegistrar.setScheduler(taskScheduler);
	}
	
}
