package com.yuansong.tools.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.IRunUntillSuccess;

@Component
public class MyTestJob implements IRunUntillSuccess {
	
	private static final Logger logger = LoggerFactory.getLogger(MyTestJob.class);

	@Override
	public String getName() {
		return "MyTestJob";
	}

	@Override
	public boolean getPremiss() {
		return true;
	}

	@Override
	public void job() throws Exception {
		logger.debug(CommonTool.UUID());
		throw new RuntimeException("exception e");
	}

	@Override
	public void prefixJob() {
		logger.debug("m p");
	}

	@Override
	public void suffixJob() {
		logger.debug("m s");
	}


}
