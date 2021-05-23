package com.yuansong.tools.demo.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.demo.global.Response;
import com.yuansong.tools.demo.global.ResponseResult;
import com.yuansong.tools.secret.ZillionWSDA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags={"tools-secret"})
@RequestMapping(value = "/tools/secret")
public class ToolsSecretController {

	private static final Logger logger = LoggerFactory.getLogger(ToolsSecretController.class);
	
	@ApiOperation(value="加密")
	@RequestMapping(value = "/encrypt",method = RequestMethod.POST)
	public ResponseResult<String> getEncryptString(String str, String key) {
		logger.debug(str + " - " + key);
		try {
			return Response.makeOKStringRsp(ZillionWSDA.EncryptToBase64Format(str, key));
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return Response.makeErrRsp();
		}
	}
	
	@ApiOperation(value="解密")
	@RequestMapping(value = "/decrypt",method = RequestMethod.POST)
	public ResponseResult<String> getT(String str, String key) {
		logger.debug(str + " - " +key);
		try {
			return Response.makeOKStringRsp(ZillionWSDA.DecryptFromBase64Format(str, key));
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return Response.makeErrRsp();
		}
	}
	
}
