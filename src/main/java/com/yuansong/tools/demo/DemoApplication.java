package com.yuansong.tools.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com.yuansong" })
@EnableAsync
public class DemoApplication {
	public static void main(String[] args) {

		long begTime = System.currentTimeMillis();

		SpringApplication.run(DemoApplication.class, args);

		long endTime = System.currentTimeMillis();

		System.out.println("\n" 
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n"
				+ "                               _     _\n" 
				+ "                              ( \\---/ )\n"
				+ "                               ) . . (\n"
				+ "-------------------------,--._(___Y___)_,--.---------------------------\n"
				+ "                         `--'           `--'\n"
				+ "                     	  demo  启动成功                   \n" 
				+ "\n" + " 启动耗时: " + (endTime - begTime)
				+ "毫秒 \n" 
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n");

	}
}
