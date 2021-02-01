package com.yuansong.tools.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yuansong.tools.db.IToolsDbHelper;
import com.yuansong.tools.db.TargetSource;
import com.yuansong.tools.demo.global.Constant;

@Repository
public class DbTestRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(DbTestRepository.class);
	
	@Autowired
	@Qualifier(IToolsDbHelper.BEAN_JDBCTEMPLATE)
	private JdbcTemplate jdbcTemplate;
	
	@TargetSource(Constant.DB_TEST)
	public List<String> getList() {
		List<String> list = this.jdbcTemplate.queryForList("select accname from zlaccount82", String.class);
		logger.debug(String.valueOf(list.size()));
		return list;
	}
	
	@TargetSource(Constant.DB_TEST)
	public List<String> getDataList() {
		List<String> list = this.jdbcTemplate.queryForList("select data from push", String.class);
		logger.debug(String.valueOf(list.size()));
		return list;
	}

}
