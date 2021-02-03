package com.yuansong.tools.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yuansong.tools.config.IToolsConfigHelper;

@Component
public class StartTask implements CommandLineRunner {
	
//	private static final Logger logger = LoggerFactory.getLogger(StartTask.class);
	
	@Autowired
	private IToolsConfigHelper toolsConfigHelper;

	@Override
	public void run(String... args) throws Exception {
		Thread t1 = new Thread(new MyRunnable(new Runnable() {
			@Override
			public void run() {
				toolsConfigHelper.debug("TEST MESSAGE", "T1");
			}
		}, "T1"));
		
		Thread t2 = new Thread(new MyRunnable(new Runnable() {
			@Override
			public void run() {
				toolsConfigHelper.debug("TEST MESSAGE", "T2");
			}
		}, "T2"));
		
		Thread t3 = new Thread(new MyRunnable(new Runnable() {
			@Override
			public void run() {
				toolsConfigHelper.debug("TEST MESSAGE", "T3");
			}
		}, "T3"));
		
		Thread t4 = new Thread(new MyRunnable(new Runnable() {
			@Override
			public void run() {
				toolsConfigHelper.debug("TEST MESSAGE", "T4");
			}
		}, "T4"));
		
		Thread.sleep(3000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class MyRunnable implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(MyRunnable.class);
	
	public MyRunnable(Runnable r, String type) {
		this.r = r;
		this.type = type;
	}
	
	private Runnable r;
	private String type;

	@Override
	public void run() {
		boolean flag = true;
		long count = 0L;
		long c = 0L;
		while(flag) {
			this.r.run();
			if(count > 50) {
				c = c + 1;
				count = 0;
				logger.debug(this.type + " " + String.valueOf(c));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				count++;
			}
		}
	}
	
}
