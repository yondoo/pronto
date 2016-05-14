package com.pronto.entities.list;

public enum RuleAction {
	UBSUBSCRIBE_FROM_LIST_WHEN_SUBSCRIBING_TO(0), UBSUBSCRIBE_FROM_LIST_WHEN_UNSUBSCRIBING_FROM(
			1), SUBSCRIBE_TO_LIST_WHEN_SUBSCRIBING_TO(2);

	private int val;

	RuleAction(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
