package com.infun.bi;

import java.math.BigDecimal;

/**
 * @author 黄培桂
 * @create 2018-08-01 17:45
 **/

public class Test {
    @org.junit.Test
    public void test(){
    BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount.add(new BigDecimal(9999));
		System.out.println(new BigDecimal(9999).intValue());
    }
}
