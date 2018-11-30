package com.infun.bi.common;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Deleted {
	//0未删除 ；1已删除
	STATE0(0), STATE1(1);
	private Integer value;
	 
    @JsonCreator
    private Deleted(Integer num) {
        this.value = num;
    }

	public Integer getValue() {
		return value;
	}
}
