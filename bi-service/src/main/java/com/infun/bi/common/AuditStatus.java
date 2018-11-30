package com.infun.bi.common;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 审核状态
 * @author liulang
 * @date 2018/8/27
 */
public enum AuditStatus {

    //审核状态 0：同意 1：不同意
    AGREE(0),REFUSE(1);

    private Integer value;

    @JsonCreator
    private AuditStatus(Integer num){
        this.value = num;
    }

    public Integer getValue(){
        return value;
    }

}
