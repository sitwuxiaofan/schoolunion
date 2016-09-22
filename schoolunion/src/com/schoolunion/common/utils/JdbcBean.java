package com.schoolunion.common.utils;

import java.io.Serializable;

public class JdbcBean implements Serializable{

	/**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	private static final long serialVersionUID = 1191621954752298143L;
	
	/**
	 * 用户名
	 */
	private String userName; 
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 数据库服务名
	 */
	private String serverName;
	
	
	/**
	 * JDBC 驱动
	 */
	private String driver;
	
	/**
	 * IP
	 */
	private String ip;
	
	/**
	 * 端口
	 */
	private String port;

	/**
	 * 数据库类型
	 */
	private String dbType;

	public JdbcBean() {
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

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	

	
	
	

}
