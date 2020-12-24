package com.yuansong.tools.demo.config;

import org.springframework.stereotype.Component;

import com.yuansong.tools.swagger.ISwaggerConfig;

@Component
public class SwaggerConfig implements ISwaggerConfig {

	@Override
	public Boolean getEnable() {
		return true;
	}

	@Override
	public String getTitle() {
		return "Title";
	}

	@Override
	public String getDescription() {
		return "Description";
	}

	@Override
	public String getVersion() {
		return "0.0.0";
	}

	@Override
	public String getBasePackage() {
		return "com.yuansong";
	}

}
