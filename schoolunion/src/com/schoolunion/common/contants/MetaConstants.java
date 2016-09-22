package com.schoolunion.common.contants;


public class MetaConstants {
	
	
	public static final  String RS_URL_ROOT_TYPE = "root_url";
	
	public static final String RS_URL_METADB_TYPE = "meta_url";
	
	public static final String RS_URL_STORAGE_TYPE = "storage_url";
	
	public static final String RS_URL_SCHEME_TYPE = "schema_url";
	
	public static final String RS_URL_STORAGE_OBJ_TYPE = "stroageobj_url";
	
	public static final String RS_URL_STORAGE_OBJ_ATTR_TYPE = "stroageobj_arr_url";
	
	public static final String RS_URL_STORAGE_OBJ_ATTR_DETAIL_TYPE = "stroageobj_arr_detail_url";
	
	public static final String RS_URL_STORAGE_OBJ_ARR_CLUSTER_TYPE = "storageobj_arr_cluster_url";
	
	public static final String RS_URL_STORAGE_OBJ_ARR_COL_TYPE = "storageobj_arr_col_url";
	
	public static final String RS_URL_STORAGE_OBJ_ARR_COL_DETAIL_TYPE = "storageobj_arr_col_detail_url";
	
	
	public static final String RS_ROOT_TYPE = "root_type";
	
	public static final String RS_META_TYPE = "meta_type";
	
	public static final String RS_STORAGE_TYPE = "storage_type";
	
	public static final String RS_SCHEME_TYPE = "schema_type";
	
	public static final String RS_STORAGE_OBJ_TYPE = "storageobj_type";
	
	public static final String RS_STORAGE_OBJ_ARR_TYPE = "storageobj_arr_type";
	
	public static final String RS_STORAGE_OBJ_ATTR_PK_TYPE = "storageobj_arr_pk_type";
	
	public static final String RS_STORAGE_OBJ_ATTR_FIELD_TYPE = "storageobj_arr_field_type";
	
	public static final String RS_STORAGE_OBJ_ARR_CLUSTER_TYPE = "storageobj_arr_cluster_type";
	
	public static final String RS_STORAGE_OBJ_ARR_RK_TYPE = "storageobj_arr_rk_type"; 
	
	public static final String RS_STORAGE_OBJ_ARR_COL_TYPE = "storageobj_arr_col_type";
	
	public static final String RS_VERSION_TYPE = "version_type";
	
	
   /**
    * 主键字段
    */
	public static String IS_PK = "1";
		
	
	/**
	 * tree根节点 id
	 */
	public static final String ROOT_NODE_ID = "0";
	
	/**
	 * tree根节点显示
	 */
	public static final  String ROOT_NODE_TXT = "数据资源目录";
	
	/**
	 * 树url属性
	 */
	public static final String TREE_URL_ARR = "urltype"; 
	
	/**
	 * 树type属性
	 */
	public static final String TREE_TYPE_ARR = "type";
	
	/**
	 * 树versionno属性
	 */
	public static final String TREE_VERSIONNO_ARR = "versionNo";
	
	/**
	 * 树storageType属性
	 */
	public static final String TREE_STORAGETYPE_ARR = "storageType";
	
    /**
     * 树节点关闭状态
     */
	public static String  TREE_STATE_COLOSED = "closed";
	
	
	/**
	 * 有效标识
	 */
	public static final String  VALID_FLAG = "1";
	
	/**
	 * 无效标识
	 */
	public static final String INVALID_FLAG = "0";
	
	
	/**
	 * 未删除标识
	 */
	public static final String NOT_DELETE_FLAG = "0";
	
	/**
	 * 已删除标识
	 */
	public static final String DELETED_FLAG = "1";
	
	/**
	 * 字典表enumValue字段
	 */
	public static final String ENUMVALUE = "enumValue";
	
	/**
	 * 驱动字段标识
	 */
	public static final String DRIVER_FIELD_FLAG = "DRIVER=";
	
	/**
	 * 驱动字段结束符号
	 */
	public static final String DRIVER_FIELD_END_FLAG = ";";
	
	

	
	
	/**
	 * 关系型
	 */
	public static String IS_RELATION = "0";
	
	/**
	 * 关系型
	 */
	public static String IS_RELATION_TYPE = "4";
	
	/**
	 * 非关系型
	 */
	public static String IS_NOT_RELATION = "1";
	
	public static String IS_RELATION_STR = "关系型";
	
	
	

	
	//列簇标识
	public final static String COLUMN_FAMILY_FLAG = "1";
	
	//列标识
	public final static String COLUMN_COL_FLAG = "0";
	
	
	/**
	 * 版本状态标示
	 */
	public final static String IS_CURRENT_VERSION="1";  //版本发布
	
	public final static String IS_CURRENT_VERSION_NOT="0"; //版本未发布
	

	
	public static final String  IS_HISTORY_VIEW = "VIEW";  
	
	
}
