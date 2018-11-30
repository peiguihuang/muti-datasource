package com.infun.bi.common;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

public class QiniuUitl {

	String ACCESS_KEY = "";//"HFxGlgNRImIxjdsbz5rOseT25nJeQjYXo-3Hlncq";
    String SECRET_KEY = "";//"maAWjOw42YiO01AMj5xWsyZWgUZl1nC-8A0yZAU3";
    //要上传的空间
//    String bucketname = "infunshop";
    String bucketname = "";//"infunshop";
    //上传到七牛后保存的文件名
//    String key = "33333.png";
    //上传文件的路径
//    String FilePath = "/.../...";
//    String FilePath = "D:\\infun\\timg.jpg";
    //密钥配置
    Auth auth = null;//Auth.create(ACCESS_KEY, SECRET_KEY);
    public QiniuUitl(String accessKey, String secretKey, String buketName){
    	this.ACCESS_KEY = accessKey;
    	this.SECRET_KEY=secretKey;
    	this.bucketname=buketName;
    	auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    }

   

    ///////////////////////指定上传的Zone的信息//////////////////
    //第一种方式: 指定具体的要上传的zone
    //注：该具体指定的方式和以下自动识别的方式选择其一即可
    //要上传的空间(bucket)的存储区域为华东时
    // Zone z = Zone.zone0();
    //要上传的空间(bucket)的存储区域为华北时
    // Zone z = Zone.zone1();
    //要上传的空间(bucket)的存储区域为华南时
    // Zone z = Zone.zone2();

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

//    public static void main(String args[]) throws IOException {
//        new UploadDemo().upload();
        //返回：{"hash":"FgUs099WAQWH_qgTnyJu7cohYLby","key":"my-java.png"}
        //返回：{"hash":"FgUs099WAQWH_qgTnyJu7cohYLby","key":"my-java.png"}
//    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public String upload(byte[] bytes,String key) throws IOException {
    	 Response res = null;
    	try {
            //调用put方法上传
            res = uploadManager.put(bytes, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
            
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            return r.toString();
//            try {
//                //响应的文本信息
//                System.out.println(r.bodyString());
//            } catch (QiniuException e1) {
//                //ignore
//            }
        }
        return res.bodyString();
    }
}
