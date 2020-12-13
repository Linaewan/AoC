package com.adventofcode.enums;

public enum OpcodeType {

	ONE(1), TWO(2), HALT(99);

	private Integer shortCode;

	private OpcodeType(Integer shortCode) {
		this.shortCode = shortCode;
	}

	public Integer getShortCode() {
		return this.shortCode;
	}
}
