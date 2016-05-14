package com.pronto.entities.subscriber;

public enum AddMethod {
	IMPORTED(0), EMAILED_AUTORESPONDER(1), WEB_FORM(2), API(3);

	private int val;

	AddMethod(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
