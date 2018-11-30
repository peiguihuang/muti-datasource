package com.infun.bi.common;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
public final class ResultMap {

    private Map<String,Object> result = new HashMap<>();

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String OVERTIME = "overtime";
    public static final String CODE = "overtime";

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置为中国上海时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        //空值不序列化
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //单引号处理
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public ResultMap failure(){
        result.put("result", FAILURE);
        return this;
    }

    public ResultMap success(){
        result.put("result", SUCCESS);
        return this;
    }

    public ResultMap overtime(){
        result.put("result", OVERTIME);
        return this;
    }

    public ResultMap errmsg(String message){
        result.put("errmsg", message);
        return this;
    }
    
    public ResultMap errcode(String errcode){
        result.put("errcode", errcode);
        return this;
    }

    public void clear(){
        result.clear();
    }

    public Map<String,Object> map(){
        return result;
    }

    public String json(){
        //ObjectMapper mapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
//			e.printStackTrace();
        }
        return null;
    }

    public ResultMap data(Object data) {
        result.put("data", data);
        return this;
    }
    public static ObjectMapper objectMapper() {
        return objectMapper;
    }
}
