package com.pronto.entities.subscriber;

public enum SubscriberStatus {
	SUBSCRIBED(0), UNSUBSCRIBED(1), NOT_CONFIRMED(2);

	private int val;

	SubscriberStatus(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
