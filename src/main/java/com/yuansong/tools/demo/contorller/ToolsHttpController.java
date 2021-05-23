package com.yuansong.tools.demo.contorller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.yuansong.tools.demo.global.Response;
import com.yuansong.tools.demo.global.ResponseResult;
import com.yuansong.tools.okhttp.IHttpUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags={"tools-http"})
@RequestMapping(value = "/tools/http")
public class ToolsHttpController {
	
	private static final Logger logger = LoggerFactory.getLogger(ToolsHttpController.class);

	@Autowired
	private IHttpUtil httpUtil;
	
	//GET
	//POST XML
	//POST JSON
	//POST FILE
	//POST FORM
	
	@ApiOperation(value="getGetHttpData")
	@RequestMapping(value = "/getGetHttpData",method = RequestMethod.POST)
	public ResponseResult<String> getGetHttpData(@RequestParam("url") String url, @RequestParam("centerNo") String centerNo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("centerNo", centerNo);
		try {
			return Response.makeOKStringRsp(httpUtil.doGet(url, params));
		} catch (Exception e) {
			logger.error(ExceptionTool.getStackTrace(e));
			return Response.makeErrRsp();
		}
	}
}
