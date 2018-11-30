package com.infun.bi.common;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
	//0 审核通过 ；1 待审核
	STATE0(0), STATE1(1);
	private Integer value;
	 
    @JsonCreator
    private Status(Integer num) {
        this.value = num;
    }

	public Integer getValue() {
		return value;
	}
}
