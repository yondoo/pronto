package com.pronto.entities.list;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.pronto.entities.core.LogObject;

@Entity
public class AutomationRule extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5679992558503966942L;

	private RuleAction action;
	@ManyToOne
	private List firstList;
	@ManyToOne
	private List secondList;

	public RuleAction getAction() {
		return action;
	}

	public void setAction(RuleAction action) {
		this.action = action;
	}

	public List getFirstList() {
		return firstList;
	}

	public void setFirstList(List firstList) {
		this.firstList = firstList;
	}

	public List getSecondList() {
		return secondList;
	}

	public void setSecondList(List secondList) {
		this.secondList = secondList;
	}

}
