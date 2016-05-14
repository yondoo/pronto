package com.pronto.entities.followup;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.pronto.entities.core.LogObject;
import com.pronto.entities.message.Message;

@Entity
public class FollowupSeries extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5695188365518698944L;

	@ManyToOne
	private Message message;
	private Integer order;
	private Integer sendInterval;
	private TimeUnit timeUnit;
	private Double spamScore;
	private Double percentOpened;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getSendInterval() {
		return sendInterval;
	}

	public void setSendInterval(Integer sendInterval) {
		this.sendInterval = sendInterval;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	public Double getSpamScore() {
		return spamScore;
	}

	public void setSpamScore(Double spamScore) {
		this.spamScore = spamScore;
	}

	public Double getPercentOpened() {
		return percentOpened;
	}

	public void setPercentOpened(Double percentOpened) {
		this.percentOpened = percentOpened;
	}

}
