package com.yuansong.tools.demo.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.db.IToolsDbHelper;
import com.yuansong.tools.demo.global.Response;
import com.yuansong.tools.demo.global.ResponseResult;
import com.yuansong.tools.demo.repository.ToolDbRepository;
import com.yuansong.tools.demo.vo.AuthorizationInfo;
import com.yuansong.tools.demo.vo.IntTaskConfig;
import com.yuansong.tools.demo.vo.Skt;
import com.yuansong.tools.demo.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags={"tools-db"})
@RequestMapping(value = "/tools/db")
public class ToolsDbController {
	
//	private static final Logger logger = LoggerFactory.getLogger(ToolsDbController.class);
	
	private static final String DB_CONN_MSSQL2000 = "MSSQL2000";
	private static final String DB_CONN_MSSQL2000UP = "MSSQL2000UP";
	private static final String DB_CONN_MYSQL = "MYSQL";
	private static final String DB_CONN_SQLITE = "SQLITE";
	
	@Autowired
	private IToolsDbHelper toolsDbHelper; 
	
	@Autowired
	private ToolDbRepository repository;
	
	@ApiOperation(value="添加MSSQL2000数据源")
	@RequestMapping(value = "/addMSSQL2000Conn",method = RequestMethod.POST)
	public ResponseResult<?> addMSSQL2000Conn(@RequestBody SQLConn conn) {
		
		toolsDbHelper.addDataSource(DB_CONN_MSSQL2000, 
				toolsDbHelper.getMSSqlConnInfo(DB_CONN_MSSQL2000, 
						conn.getServer(), conn.getDbName(), conn.getUserName(), conn.getPassword()));
		
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="移除MSSQL2000数据源")
	@RequestMapping(value = "/removeMSSQL2000Conn",method = RequestMethod.GET)
	public ResponseResult<?> removeMSSQL2000Conn() {
		toolsDbHelper.removeDataSource(DB_CONN_MSSQL2000);
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="获取MSSQL2000数据")
	@RequestMapping(value = "/getMSSQL2000Data",method = RequestMethod.POST)
	public ResponseResult<List<AuthorizationInfo>> getMSSQL2000Data() {
		return Response.makeOKRsp(repository.getMSSQL2000Data());
	}
	
	@ApiOperation(value="添加MSSQL2000UP数据源")
	@RequestMapping(value = "/addMSSQL2000UPConn",method = RequestMethod.POST)
	public ResponseResult<?> addMSSQL2000UPConn(@RequestBody SQLConn conn) {
		
		toolsDbHelper.addDataSource(DB_CONN_MSSQL2000UP, 
				toolsDbHelper.getMSSqlConnInfo(DB_CONN_MSSQL2000UP, 
						conn.getServer(), conn.getDbName(), conn.getUserName(), conn.getPassword()));
		
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="移除MSSQL2000UP数据源")
	@RequestMapping(value = "/removeMSSQL2000UPConn",method = RequestMethod.GET)
	public ResponseResult<?> removeMSSQL2000UPConn() {		
		toolsDbHelper.removeDataSource(DB_CONN_MSSQL2000UP);
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="获取MSSQL2000UP数据")
	@RequestMapping(value = "/getMSSQL2000UPData",method = RequestMethod.POST)
	public ResponseResult<List<IntTaskConfig>> getMSSQL2000UPData() {
		return Response.makeOKRsp(repository.getMSSQL2000UPData());
	}
	
	@ApiOperation(value="添加MYSQL数据源")
	@RequestMapping(value = "/addMYSQLConn",method = RequestMethod.POST)
	public ResponseResult<?> addMYSQLConn(@RequestBody SQLConn conn) {
		
		toolsDbHelper.addDataSource(DB_CONN_MYSQL, 
				toolsDbHelper.getMySqlConnInfo(DB_CONN_MYSQL, 
						conn.getServer(), conn.getDbName(), conn.getUserName(), conn.getPassword()));
		
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="移除MYSQL数据源")
	@RequestMapping(value = "/removeMYSQLConn",method = RequestMethod.GET)
	public ResponseResult<?> removeMYSQLConn() {
		toolsDbHelper.removeDataSource(DB_CONN_MYSQL);
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="获取MYSQL数据")
	@RequestMapping(value = "/getMYSQLData",method = RequestMethod.POST)
	public ResponseResult<List<User>> getMYSQLData() {
		return Response.makeOKRsp(repository.getMYSQLData());
	}
	
	@ApiOperation(value="添加SQLITE数据源")
	@RequestMapping(value = "/addSQLITEConn",method = RequestMethod.POST)
	public ResponseResult<?> addSQLITEConn(@RequestBody SQLiteConn conn) {
		toolsDbHelper.addDataSource(DB_CONN_SQLITE, 
				toolsDbHelper.getSQLiteConnInfo(DB_CONN_SQLITE, conn.getPath()));
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="移除SQLITE数据源")
	@RequestMapping(value = "/removeSQLITEConn",method = RequestMethod.GET)
	public ResponseResult<?> removeSQLITEConn() {
		toolsDbHelper.removeDataSource(DB_CONN_SQLITE);
		return Response.makeOKRsp();
	}
	
	@ApiOperation(value="查询现有数据源数量")
	@RequestMapping(value = "/getConnList",method = RequestMethod.GET)
	public ResponseResult<Long> getConnList() {
		return Response.makeOKRsp(toolsDbHelper.size());
	}
	
	@ApiOperation(value="获取SQLITE数据")
	@RequestMapping(value = "/getSQLITEData",method = RequestMethod.POST)
	public ResponseResult<List<Skt>> getSQLITEData() {
		return Response.makeOKRsp(repository.getSQLITEData());
	}

}

class SQLConn{
	@ApiModelProperty("url")
	private String server;
	@ApiModelProperty("数据库名称")
	private String dbName;
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("密码")
	private String password;
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

class SQLiteConn{
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}

