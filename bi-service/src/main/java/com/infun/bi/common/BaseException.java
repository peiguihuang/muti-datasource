package com.infun.bi.common;

/**
 * 
 * <p>Title: 自定义异常处理类</p>
 * <p>Description: 封装错误码等信息,自定义错误码</p>
 * @author ysh
 * @date 2017年5月26日
 */
public class BaseException extends Exception {
	public static final String  ERR_OBJ_NULL = "USER0001";// 输入参数对象为空
	public static final String ERR_PARA_NULL = "USER0002";// 输入参数为空
	public static final String ERR_PARSE_MAP = "USER0003";// map对象转化String错误
	public static final String ERR_CLIENT_TYPE = "USER0004";// 获取客户端类型错误
	public static final String ERR_PARTNERID_NULL = "USER0005";// 合作伙伴id为空
	public static final String ERR_PARTNER_CARD_NO = "USER0006";// 商家会员编号错误
	public static final String ERR_PARTNER_CARD_OUT = "USER0007";// 商家预制卡号用尽
	public static final String ERR_TASK_DDL = "USER0008";// 定时任务数据库操作错误
	public static final String ERR_DATA_NULL = "USER0009";// 结果集为空
	public static final String ERR_SYS_SELECT = "USER0010";// 查询出错
	public static final String ERR_DDL_COND = "USER0011";// 操作条件不正确
	public static final String ERR_DDL_NODATA = "USER0012";// 没有对应的数据
	public static final String ERR_DDL_DATAEXIST = "USER0013";// 数据已存在
	public static final String ERR_TYPE = "USER0014";// 不存在的操作类型
	public static final String ERR_DDL_OPERATE = "USER0011";// 操作数据库错误
	public static final String SUCESS = "11111";//成功，范围11000-11999
	public static final String KEY_NULL = "11001";//主键为空，范围11000-11999
	public static final String HAVE_DATA = "11002";//数据已存在，范围11000-11999
	public static final String HAVE_NO_USER = "11003";//不存在该手机号的惠豆会员，范围11000-11999
	public static final String DATA_NO_USE = "11004";//数据未被使用，范围11000-11999
	public static final String ERR_PARAS = "11005";//输入参数有误，范围11000-11999
	public static final String ERR_SELECT_NODATA = "11006";//没有查询结果
	public static final String DATA_HAVE_USE = "11007";//数据已被使用在，范围11000-11999
	public static final String ERR_GENERATE_SERIAL = "11008";//生产编号错误
	public static final String ERR_SYSTEM = "11009";//系统错误
	public static final String ERR_DDL_CREATE = "11010";// 操作数据库保存错误
	public static final String ERR_PURCHSERIAL="11020";//获取流水号错误
	public static final String ERR_REDIS_SAVE="11021";//redis 保存异常
	public static final String ERR_REDIS_SEARCH="11022";//redis 查询异常
	public static final String ERR_REDIS_DESTROY="11023";//redis 清除异常
	public static final String ERR_REMOTE_CALL="11024";//远程调用异常
	
	public static final String YES="YES";//是
	public static final String NO="NO";//否
	public static final String SUCCESS="success";//成功返回标识
	public static final String FAILURE="failure";//成功返回标识	
	public static final String ZERO="0";//零
	public static final String NONE="NONE";//无
	/**
	 * 
	 */
	private static final long serialVersionUID = 847883204109124400L;

	/**
	* 错误编码
	*/
	private String errorCode;

	/**
	* 消息是否为属性文件中的Key
	*/
	private boolean propertiesKey = true;

	/**
	* 构造一个基本异常.
	*
	* @param message
	*            信息描述
	*/
	public BaseException(String message) {
		super(message);
	}

	/**
	* 构造一个基本异常.
	*
	* @param errorCode
	*            错误编码
	* @param message
	*            信息描述
	*/
	public BaseException(String errorCode, String message) {
		this(errorCode, message, true);
	}

	/**
	* 构造一个基本异常.
	*
	* @param errorCode
	*            错误编码
	* @param message
	*            信息描述
	*/
	public BaseException(String errorCode, String message, Throwable cause) {
		this(errorCode, message, cause, true);
	}

	/**
	* 构造一个基本异常.
	*
	* @param errorCode
	*            错误编码
	* @param message
	*            信息描述
	* @param propertiesKey
	*            消息是否为属性文件中的Key
	*/
	public BaseException(String errorCode, String message, boolean propertiesKey) {
		super(message);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	/**
	* 构造一个基本异常.
	*
	* @param errorCode
	*            错误编码
	* @param message
	*            信息描述
	*/
	public BaseException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
		super(message, cause);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	/**
	* 构造一个基本异常.
	*
	* @param message
	*            信息描述
	* @param cause
	*            根异常类（可以存入任何异常）
	*/
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isPropertiesKey() {
		return propertiesKey;
	}

	public void setPropertiesKey(boolean propertiesKey) {
		this.propertiesKey = propertiesKey;
	}
}
