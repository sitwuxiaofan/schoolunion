package com.schoolunion.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schoolunion.common.contants.Constants;

public class JdbcUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

	private static Connection getConnection(JdbcBean JdbcBean) {

		String dbUrl = getDbUrlByDbType(JdbcBean);
		Connection conn = null;

		LoadDrive(JdbcBean.getDriver());

		try {
			conn = DriverManager.getConnection(dbUrl, JdbcBean.getUserName(),
					JdbcBean.getPassword());
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		return conn;
	}

	private static void LoadDrive(String driver) {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			logger.error(e1.getMessage(), e1);
		}

	}

	private static String getDbUrlByDbType(JdbcBean JdbcBean) {

		String dbType = JdbcBean.getDbType();

		if (dbType.equals(Constants.SQL_SERVER)) {
			
			String url = Constants.SQL_SERVER_DURLHEAD + JdbcBean.getIp() + ":"+ JdbcBean.getPort() + ";DatabaseName=" + JdbcBean.getServerName();
			return url;
		} else if (dbType.equals(Constants.ORACLE_TYPE)) {
			return Constants.ORACLE_DURLHEAD + JdbcBean.getIp() + ":" + JdbcBean.getPort() + "/" + JdbcBean.getServerName();
		} else {
			return null;
		}

	}

	public static List<Map> findBySql(String sql,
			JdbcBean JdbcBean) {

		Connection conn = getConnection(JdbcBean);

		PreparedStatement pst = null;
		ResultSet rs = null;
		List result = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			result = resultSetToList(rs);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			close(rs, pst, conn);
		}

		return result;
	}

	private static void close(ResultSet rs, PreparedStatement pst,
			Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			} finally {
				if (pst != null) {
					try {
						pst.close();
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (Exception e) {
								logger.error(e.getMessage(), e);
							}
						}
					}
				}
			}
		}

	}

	private static List resultSetToList(ResultSet rs) {
		if (rs == null)
			return Collections.EMPTY_LIST;

		List list = new ArrayList();
		try {
			ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
			int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数

			Map rowData = new HashMap<String, Object>();
			while (rs.next()) {
				rowData = new HashMap(columnCount);
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getString(i));
				}
				list.add(rowData);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		return list;
	}

}
