package com.bboss.util;

public class ECPConstants {
	public static class ResType{
		public static final String DATA_RES = "DATA_RIGHT";
		public static final String FUNC_RES = "FUNC_RIGHT";
		public static final String MENU_RES = "MENU_RIGHT";
	}
	
	public static class DataCode{
		public static final String ORDER_ALL = "DATA_ORDER_ALL";
		
	}
	
	public static class InterfaceCode{
		public  static final String SUCCESS = "10000";//请求成功
		public  static final String EXCEPTION = "10001";//参数异常
		public  static final String PARAMTER_NULL = "10002";//参数为空
		public  static final String REQUEST_INCORRECT = "10003";//请求不合法
		public  static final String REQUEST_VERRIFY_ERROR = "10004";//请求校验错误
		public  static final String REQUEST_OBTAIN_ERROR = "10005";//数据获取异常
		public  static final String SYSTEM_ERROR = "20000";//系统错误
		public  static final String VERSION_DISABLE = "30000";//版本已禁用
		public  static final String DATA_EXPIRE = "40000";//数据已过期
		public  static final String DATA_INSERT_FAIL = "50000";//数据新增失败
	}
	
	public static class InteferUrl{
		/*
		public static final String BASE_URL = (PropertiesUtil.readProperties()).getProperty("interface.baseurl");
		public static final String DOWNLOAD_SERVICE_URL = (PropertiesUtil.readProperties()).getProperty("interface.download.url");
		*/
		public static final String GET_FLOEPOOL_MONTH_SUM = "/data/flowpool/monthSummary";
		public static final String GET_FLOEPOOL_DAY_SUM = "/data/flowpool/daySummary";
		public static final String GET_PERMISSION = "/auth/authRes";
		public static final String GET_CUST_PRODUCT_LIST = "/data/custProduct/list";
		public static final String GET_CUST_PRODUCT_DAYLIST = "/data/custProduct/daylist";

		
		public static final String GROUP_ADD_WARNING_RECEIVER = "/warning/groupAddReceiver";
		public static final String GROUP_DELETE_WARNING_RECEIVER = "/warning/removeReceiver";
		public static final String GROUP_UPDATE_WARNING_RECEIVER = "/warning/updateReceiver";
		public static final String GROUP_UPDATE_WARNING_THRESHOLD = "/warning/updateGroupItemValue";
		public static final String GROUP_UPDATE_WARNING_ITEM_STATUS = "/warning/chGroupItemStatus";
		
		public static final String GET_GROUP_WARNING_ITEM = "/warning/groupWarningItems";
		public static final String GET_GROUP_WARNING_RECEIVER = "/warning/groupWarningReceivers";
		public static final String GET_GROUP_WARNING_CONFIGURE = "/warning/groupWarningConfigures";
		public static final String GET_GROUP_WARNING_ITEM_CONFIGURE = "/warning/groupWarningItemsAndConfigures";
	}
	
	public static class  SysPattern{
		public static final String  AUTHID_PATTERN = "^[GMEZJ]\\d+$";
		public static final String  DATE_PATTERN = "^\\d{4}-\\d{2}$";
		
	}
	
	public static class UserTag{
		public static final String  YUNYINGJITUAN  ="G";
		public static final String  KEHUJINGLI  ="M";
		public static final String  EC  ="E";
		public static final String  ZIGUANZU  ="Z";
		public static final String  JIEKOUREN  ="J";
	} 
	public static class UserRoleType{
		public static final int  YUNYINGJITUAN  = 3;
		public static final int  KEHUJINGLI  = 4;
		public static final int  EC  = 5;
		public static final int  ZIGUANZU  = 6;
		public static final int  JIEKOUREN  = 7;
	}
	
	public static class UserType{
		public static final String  SUPERADMIN  = "超级管理员";
	} 
	
	
	
	public static class AesKey{
		public static final String  AES_CODE  ="6wNwJUCfpXKzyyGvVhGmzHeG";
		public static final String  CLIENT_CODE  ="ecserviceaescode";
	} 
	
	public static class RedisConf{
		public static class RedisKey{
			public static final String  MESSAGE_COUNT_KEY  ="_msgCount";
			public static final String  MENU_INFO_KEY  ="_menuInfo";
			public static final String  SUBSCRIPTION_LIST_KEY  ="_subList";
		}
		public static class RedisExpire{
			public static final Integer  HOURS_24  =24*60*60*1000;
			public static final Integer  MINUTES_30  =30*60*1000;
		}
		
	} 
	
	public static  class  DateFormat{
		public static final String SQL_MONTH_FORMAT= "yyyyMM";
		public static final String JSP_MONTH_FORMAT= "yyyy-MM";
		public static final String SQL_DATE_FORMAT= "yyyyMMdd";
		public static final String JSP_DATE_FORMAT= "yyyy-MM-dd";
	}
}
