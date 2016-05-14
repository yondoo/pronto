package com.pronto.entities.message;

public enum MessageStatus {
	DRAFT(0), ACTIVE(1), INACTIVE(2);

	private int val;

	MessageStatus(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
