package com.infun.bi.client.message;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(MessageServiceUrlConstant.UNION_AUTH_INSTANCE)
public interface IMessageClient extends MessageServiceUrlConstant {


//	@RequestMapping(value = UNION_AUTH_ROLES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	Map<String, Object> queryRoles(@RequestBody Map<String, Object> json);

	@RequestMapping(value = MOBILE_MSG_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> sendMobileMsg(@RequestBody Map<String, Object> json);

	@RequestMapping(value = VERIFYCODE_CHECKSMSCODE,method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> iscode(String json);
}
