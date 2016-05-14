package com.pronto.entities.form;

public enum PageType {
	BASIC(0), CUSTOM_PAGE(1), STAY_ON_CURRENT_PAGE(2);

	private int val;

	PageType(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
