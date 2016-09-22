package com.schoolunion.common.contants;

/**
 * 常量类
 * @author Administrator
 *
 */
public class ResouceConstants {

	public static String RS_METADATA_TYPE = "1";
	
	public static String RS_STORAGE_TYPE = "2";
	
	public static String RS_SCHEME_TYPE = "3";
	
	public static String RS_STORAGE_OBJ_TYPE = "4";
	
	public static String RS_STORAGE_OBJ_ATTR_TYPE = "5";
	/*********************服务状态  start**************/
	/**
	 * 创建或修改-1
	 */
	public static String SERVICE_NotAUDIT_STATE = "1";
	/**
	 * 提交-2
	 */
	public static String SERVICE_INAUDIT_STATE = "2";
	/**
	 * 已审核-3
	 */
	public static String SERVICE_AUDIT_STATE = "3";
	/**
	 * 已发布-4
	 */
	public static String SERVICE_PUBLISHED_STATE = "4";
	/**
	 * 开启-5
	 */
	public static String SERVICE_OPEN_STATE = "5";
	/**
	 * 关闭-6
	 */
	public static String SERVICE_CLOSE_STATE = "6";
	
	/**
	 * 是否当前版本标识
	 */
	public static final String IS_CURRENT_VERSION = "1";
	
	/*********************服务状态  end**************/
	
	
	/**
	 * 有效性监控-有效状态"1"
	 */
	public static final String MOINTOR_VALID = "1";
	
	/**
	 * 有效性监控-无效状态"0"
	 */
	public static final String MOINTOR_INVALID = "0";
	
	/**
	 * 有效性监控-对象不存在
	 */
	public static final String MONITOR_OBJECT_UNEXIST = "对象不存在！";
	
	/**
	 * 有效性监控-属性不存在
	 */
	public static final String MONITOR_FIELD_UNEXIST = "属性不存在！";
	
	/**
	 * 有效性监控-实例无效
	 */
	public static final String MONITOR_INSTANCE_INVALID = "实例无效！";
	
	/**
	 * 有效性监控-未知原因
	 */
	public static final String MONITOR_UNKOWN = "未知原因！";
	

	/**
	 * 服务角色
	 */
	public static final String SERVICE_AUDIT_ROLE = "audit_service_role";
	
	/**
	 * 积分管理-积分指标编号生成序列。
	 */
	public static final String SEQ_POINTS_INDEX = "SEQ_POINTS_INDEX";
	
	/**
	 * 积分管理-积分指标编号前缀
	 */
	public static final String Idx = "Idx";

}
