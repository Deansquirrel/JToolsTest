package com.yuansong.tools.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.tools.db.IToolsDbHelper;
import com.yuansong.tools.db.TargetSource;
import com.yuansong.tools.demo.vo.AuthorizationInfo;
import com.yuansong.tools.demo.vo.IntTaskConfig;
import com.yuansong.tools.demo.vo.Skt;
import com.yuansong.tools.demo.vo.User;

@Repository
public class ToolDbRepository {
	
	@Autowired
	@Qualifier(value=IToolsDbHelper.BEAN_JDBCTEMPLATE)
	private JdbcTemplate jdbcTemplate;
	
	@TargetSource("MSSQL2000")
	public List<AuthorizationInfo> getMSSQL2000Data() {
		String sql = "SELECT authorizer_appid, authorizer_access_token, authorizer_refresh_token, expires_Time, UpdateTime FROM Authorization_info";
		
		return  jdbcTemplate.query(sql, new RowMapper<AuthorizationInfo>() {

			@Override
			public AuthorizationInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				AuthorizationInfo d = new AuthorizationInfo();
				d.setAuthorizerAppid(SQLTool.getNString(rs, "authorizer_appid"));
				d.setAuthorizerAccessToken(SQLTool.getNString(rs, "authorizer_access_token"));
				d.setAuthorizerRefreshToken(SQLTool.getNString(rs, "authorizer_refresh_token"));
				d.setExpiresTime(DateTool.GetDateTimeStr(SQLTool.getDatetime(rs, "expires_Time")));
				d.setUpdateTime(DateTool.GetDateTimeStr(SQLTool.getDatetime(rs, "UpdateTime")));
				return d;
			}
		});
	}
	
	@TargetSource("MSSQL2000UP")
	public List<IntTaskConfig> getMSSQL2000UPData() {
		String sql = "SELECT FId, FServer, FPort, FDbName, FDbUser, FDbPwd, FCron, FCheckMax, FCheckMin, FMsgTitle, FMsgContent, FRemark, FTitle FROM IntTaskConfig";
		
		return  jdbcTemplate.query(sql, new RowMapper<IntTaskConfig>() {

			@Override
			public IntTaskConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
				IntTaskConfig d = new IntTaskConfig();
				d.setFId(SQLTool.getNString(rs, "FId"));
				d.setFServer(SQLTool.getNString(rs, "FServer"));
				return d;
			}
		});
	}

	@TargetSource("MYSQL")
	public List<User> getMYSQLData() {
		String sql = "select id, name, sex from user";
		
		return  jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User d = new User();
				d.setId(SQLTool.getInt(rs, "id"));
				d.setName(SQLTool.getString(rs, "name"));
				d.setSex(SQLTool.getString(rs, "sex"));
				return d;
			}
		});
	}
	
	@TargetSource("SQLITE")
	public List<Skt> getSQLITEData() {
		String sql = "select lsh, bs_dj, bs_dj_nb from skt";
		
		return  jdbcTemplate.query(sql, new RowMapper<Skt>() {

			@Override
			public Skt mapRow(ResultSet rs, int rowNum) throws SQLException {
				Skt d = new Skt();
				d.setLsh(SQLTool.getString(rs, "lsh"));
				d.setBsDj(SQLTool.getInt(rs, "bs_dj"));
				d.setBsDjNb(SQLTool.getInt(rs, "bs_dj_nb"));
				return d;
			}
		});
	}
}