package com.yuansong.tools.demo.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.db.IToolsDbHelper;
import com.yuansong.tools.db.conn.MSSqlConnInfo;
import com.yuansong.tools.db.conn.MySqlConnInfo;
import com.yuansong.tools.db.conn.SQLiteConnInfo;
import com.yuansong.tools.demo.global.Constant;
import com.yuansong.tools.demo.repository.DbTestRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	private IToolsDbHelper toolsDbHelper;
	
	@Autowired
	private DbTestRepository dbTestRepository;
	
	@ApiOperation(value = "body")
	@RequestMapping(value = "/action",method = RequestMethod.POST)
	public String getBody(@RequestBody String body) {
		logger.debug(body);
		
		toolsDbHelper.addDataSource(Constant.DB_TEST, new MSSqlConnInfo(Constant.DB_TEST, "192.168.5.1:2003", "master", "sa", ""));
		for(String d : this.dbTestRepository.getList()) {
			logger.debug(d);
		}
		toolsDbHelper.removeDataSource(Constant.DB_TEST);
		toolsDbHelper.addDataSource(Constant.DB_TEST, new MySqlConnInfo(Constant.DB_TEST, "192.168.5.4:3306", "mysql", "root", "root"));
		for(String d : this.dbTestRepository.getList()) {
			logger.debug(d);
		}
		toolsDbHelper.removeDataSource(Constant.DB_TEST);
		
		toolsDbHelper.addDataSource(Constant.DB_TEST, new SQLiteConnInfo(Constant.DB_TEST, "D:\\TWFile\\tt\\push——01.db"));
		for(String d: this.dbTestRepository.getDataList()) {
			logger.debug(d);
		}
		toolsDbHelper.removeDataSource(Constant.DB_TEST);

		
		return body;
	}

}
