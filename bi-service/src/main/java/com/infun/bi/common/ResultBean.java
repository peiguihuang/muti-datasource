package com.infun.bi.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infun.bi.exception.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResultBean {

	private String result;

	private String errmsg;

	private Object data;
	
	private String resultCode;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 出错状态
	 */
	public static ResultBean errorResult(ErrorCode errorcode) {
		ResultBean rb = new ResultBean();
		rb.setResult("failure");
		rb.setErrmsg(errorcode.message());
		rb.setResultCode(errorcode.code());
		return rb;
	}
	
	/**
	 * 出错状态
	 */
	public static ResultBean errorResult(ErrorCode errorcode , Object errormsg) {
		ResultBean rb = new ResultBean();
		rb.setResult("failure");
		rb.setErrmsg(errorcode.message(errormsg));
		rb.setResultCode(errorcode.code());
		return rb;
	}
	
	/**
	 * 出错状态
	 */
	public static ResultBean errorResult(String errorcode , String errormsg) {
		ResultBean rb = new ResultBean();
		rb.setResult("failure");
		rb.setErrmsg(errormsg);
		rb.setResultCode(errorcode);
		return rb;
	}
	
	/**
	 * 成功状态
	 */
	public static ResultBean successResult(Object data) {
		ResultBean rb = new ResultBean();
		rb.setResult("success");
		rb.setErrmsg(ErrorCode.SUCCESS.message());
		rb.setResultCode(ErrorCode.SUCCESS.code());
		rb.setData(data);
		return rb;
	}
	
	/**
	 * 成功状态
	 */
	public static ResultBean successResult(String errorcode, Object data) {
		ResultBean rb = new ResultBean();
		rb.setResult("success");
		//rb.setErrmsg(ErrorCode.SUCCESS.message());
		rb.setResultCode(errorcode);
		rb.setData(data);
		return rb;
	}

	/**
	 * 返回响应
	 */
	public ResponseEntity<String> buildResponse() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		String srt = "";
		try {
			srt = new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) { }
		return new ResponseEntity<String>(srt, headers, HttpStatus.OK);
	}
	
	/**
	 * 返回响应
	 */
	public static ResponseEntity<String> buildResponse(Object obj){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		String srt = "";
		try {
			srt = new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) { }
		return new ResponseEntity<String>(srt, headers, HttpStatus.OK);
	}

	@Override
	public String toString() {
		String srt = "";
		try {
			srt = new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) { }
		return srt;
	}
}
