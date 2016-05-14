package com.pronto.entities.followup;

public enum TimeUnit {
	DAY(0), HOUR(1), MINUTE(2), SECOND(3);

	private int val;

	TimeUnit(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
