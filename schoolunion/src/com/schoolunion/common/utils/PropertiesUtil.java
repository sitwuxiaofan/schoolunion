package com.schoolunion.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

	/**
	 * 采用静态方法
	 */
	private static Properties props = null;

	private static Logger logger = Logger.getLogger(PropertiesUtil.class);
	
	private static String propName= "application.properties";


	public PropertiesUtil() {
		LoadProperties();
	}
	
	public PropertiesUtil(String propName) {
		this.propName = propName;
		LoadProperties();
	}


	/**
	 * 加载resources 配置文件 ֵ
	 * 
	 * @param key
	 *            主键
	 * @return String
	 */
	public void LoadProperties() {

		if (props != null)
			return;

		props = new Properties();
		InputStream isInputStream = this.getClass().getClassLoader().getResourceAsStream(propName);
		try {
			props.load(isInputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}



	/**
	 * 根据key 获取对应 的valueֵ
	 * 
	 * @param key
	 *            ����
	 * @return String
	 */
	public String getKeyValue(String key) {
		return props.getProperty(key);
	}
	
	

}
