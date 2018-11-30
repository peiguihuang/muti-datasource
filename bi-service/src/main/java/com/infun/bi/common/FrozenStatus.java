package com.infun.bi.common;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 冻结状态
 * @author liulang
 * @date 2018/8/25
 */
public enum  FrozenStatus {

    /**
     * 冻结状态： 0：已冻结，1：已完成， 2：已释放 -->提现失败时释放冻结金额
     */
    FROZEN(0),COMPLETE(1),RELEASE(2);

    private Integer value;

    @JsonCreator
    private FrozenStatus(Integer num){
        this.value = num;
    }
    public Integer getValue() {
        return value;
    }


}
