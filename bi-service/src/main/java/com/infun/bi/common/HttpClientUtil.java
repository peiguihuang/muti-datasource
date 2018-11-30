package com.infun.bi.common;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http请求工具类
 *
 * @author 黄培桂
 * @create 2018-07-30 9:55
 **/

public class HttpClientUtil {

    private static final CloseableHttpClient httpClient;
    public static final String CHARSET = "UTF-8";
    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }


    public static String sendGet(String url, Map<String, Object> params, String head) {
        if(StringUtils.isEmpty(url)){
            return "";
        }
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (String key : params.keySet()) {
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, CHARSET));
            }
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("access-token",head);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String sendPost(String url, Map<String, Object> params) {
        if(StringUtils.isEmpty(url)){
            return "";
        }
        try {
            List<NameValuePair> pairs = null;
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (String key : params.keySet()) {
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
            }
            HttpPost httpPost = new HttpPost(url);
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String sendPostRaw(String url, String json, String head) {
        if(StringUtils.isEmpty(url)){
            return "";
        }
        try {
            HttpPost post = new HttpPost(url);
            StringEntity postingString = new StringEntity(json,"utf-8");// json传递
            post.setHeader("Content-Type", "application/json");
            post.setHeader("access-token",head);
            post.setHeader("Cache-Control","no-cache");
//            post.setEntity(postingString);
            //post.setHeader("Cookies","9vlusukfpjt2gm03mkh51vvlg1");
            HttpResponse response = httpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String sendPostRawTest(String url, String map, String head) {
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\n\t\"classify_id\":"+map.get("classify_id")+",\n\t\"name\":\""+map.get("name")+"\",\n\t\"administrator\":\"" + map.get("administrator") + "\",\n\t\"password\":\"" + map.get("password") + "\",\n\t\"level\":1\n}");
        //RequestBody body = RequestBody.create(mediaType, "{\n\t\"classify_id\":"+map.get("classify_id")+",\n\t\"name\":\""+map.get("name")+"\",\n\t\"administrator\":\"" + map.get("administrator") + "\",\n\t\"password\":\"" + map.get("password") + "\",\n\t\"level\":"+ map.get("level")+ "\n}");
        RequestBody body = RequestBody.create(mediaType, map);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("access-token", head)
                .addHeader("Cache-Control", "no-cache")
        //          .addHeader("Postman-Token", "6c603187-cd0b-4716-b137-5ff436793d62")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
