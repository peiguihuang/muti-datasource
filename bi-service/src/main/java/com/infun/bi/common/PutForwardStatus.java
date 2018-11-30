package com.infun.bi.common;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 提现状态
 * @author liulang
 * @date 2018/8/25
 */
public enum PutForwardStatus {

    /**
     * 提现状态： 0：提现成功， 1：提现失败
     */
    PUT_SUCCESS(0),PUT_FAILURE(1);

    private Integer value;

    @JsonCreator
    private PutForwardStatus(Integer num) {
        this.value = num;
    }

    public Integer getValue() {
        return value;
    }

}
