package com.infun.bi.exception;

import java.text.MessageFormat;
import java.util.HashMap;

public enum ErrorCode {
	/** 请求出错 */
	ERROR(10000),
	/** 请求成功 */
	SUCCESS(20000),
	/** 错误，并返回信息 */
	ERR_INFO(20001),
	/** 无效参数格式 */
	ERR_PARAM_FORMAT(20002),
	/** 参数不合法 */
	ERR_INVALID_PARAM(20003),
	/** 调用partner失败！ */
	ERR_SERVER_PARTNER_INFO(20004),
	/** 调用point失败！ */
	ERR_SERVER_POINT_INFO(20005),
	/** 请求结果为空*/
	ERR_EMPTY_RESULT(20006),
	/** 同盾系统出错*/
	ERR_RISK_REJECT(20007),
	/** 请求crm返回失败*/
	ERR_FAST_REGISTER(20008),
	/**连接超时*/
	CONNECTION_TIMEOUT(20009),
	/**好邻居错误信息*/
	ERR_HLJ(20010),
	/**内部错误*/
	INTERNAL_ERROR(20011),
	/** 时间戳过期 */
	ERR_EXPIRE_TIMESTAMP(20012),
	/** 签名不正确 */
	ERR_INVALID_SIGN(20013),
	/** 请求reorder失败*/
	ERR_REORDER_FAIL(20014),
	ERR_HYSTRIX(20015),
	/** 今豆支付二维码过期 */
	ERR_EXPIRE_PAY(20016),
	/** 今豆支付余额不足 */
	ERR_PAY_BEAN_NOT_ENOUGH(20017),
	/** 取消预核销失败 */
	ERR_COUPON_CANCEL(20019),
	/** 实体卡今豆消费数量不能大于1 */
	ERR_PAY_BEAN_PARTNER_CARD(20020),
	/** 系统异常*/
	ERR_SYS_EXCEPTION(20021),
	/** 参数为空 */
	ERROR_PARA_NULL(50002),
	/** 查询数据为空 */
	ERROR_SELECT_NULL(50003),
	/** 查询远程数据为空 */
	ERROR_REMOTE_NULL(50004);



	private int nCode;

	private ErrorCode(int _nCode) {
		this.nCode = _nCode;
	}

	public String message() {
		return ErrorCode.get(nCode);
	}

	public String code(){
		return String.valueOf(nCode);
	}

	public String message(Object errinfo) {
		return MessageFormat.format(ErrorCode.get(nCode), errinfo);
	}

	/** 状态码 */
	public static final HashMap<Integer, String> ErrorCode = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;

		{
			put(10000, "请求出错");
			put(20000, "请求成功");
			put(20001, "请求出错 , 原因：{0}");
			put(20002, "无效参数格式");
			put(20003, "参数不合法");
			put(20004, "调用[partner]失败 ! 原因：{0}");
			put(20005, "调用[point  ]失败 ！ 原因：{0}");
			put(20006, "请求结果为空");
			put(20007, "请求被同盾拒绝");
			put(20008, "调用[crm]结果:{0}");
			put(20009, "失败,错误详情:{0}");
			put(20010, "好邻居错误信息:{0}");
			put(20011, "内部错误:{0}");
			put(20012, "时间戳过期");
			put(20013, "签名不正确");
			put(20014, "调用[reorder]结果 !，原因：{0}");
			put(20015, "请求出错, 请稍候重试");
			put(20016, "今豆支付二维码过期");
			put(20017, "今豆支付余额不足");
			put(20019, "重复流水号，取消预核销失败");
			put(20020, "实体卡今豆消费数量不能大于1");
			put(50000, "系统错误");
			put(50001, "请求成功");
			put(50002, "参数为空 ");
			put(50003, "本地查询数据为空 ");
			put(50004, "远程查询数据为空 ");

		}
	};
}