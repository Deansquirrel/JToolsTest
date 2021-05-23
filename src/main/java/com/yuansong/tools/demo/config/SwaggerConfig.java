package com.yuansong.tools.demo.config;

import org.springframework.stereotype.Component;

import com.yuansong.tools.swagger.ISwaggerConfig;

import springfox.documentation.service.Tag;

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

	@Override
	public Tag[] getControllerTags() {
		Tag[] tags = { 
				new Tag("tools-secret", "tools-secret"),
				new Tag("tools-db", "tools-db")
				};
		return tags;
	}

}
