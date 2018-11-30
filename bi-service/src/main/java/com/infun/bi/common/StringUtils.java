package com.infun.bi.common;

import java.util.UUID;

public class StringUtils {
	/**生成uuid
	 * 
	 * @return
	 */
	public static String genUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static boolean isEmpty(String str){
		if (str!=null && !"".equals(str)){
			return false;
		}
		return true;
	}
}
