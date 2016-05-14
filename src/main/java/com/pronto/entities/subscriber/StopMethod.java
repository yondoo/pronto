package com.pronto.entities.subscriber;

public enum StopMethod {
	UNSUBSCRIBE_LINK(0), UNSUBSCRIBED_MANUALLY(1), UNDELIVERABLE(2), API(3), API_MOVE(4);

	private int val;

	StopMethod(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
