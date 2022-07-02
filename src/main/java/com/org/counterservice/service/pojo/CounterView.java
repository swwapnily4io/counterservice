package com.org.counterservice.service.pojo;

import java.util.Map;

import javax.persistence.Id;

public class CounterView {

	@Id
	private long counterId;
	
	private String counterDesc;
	
	private long counterValue;

	public long getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(long counterValue) {
		this.counterValue = counterValue;
	}

	private Map<String, Object> customParam;

	
	public CounterView(long counterId, String counterDesc, long counterValue, Map<String, Object> customParam) {
		super();
		this.counterId = counterId;
		this.counterDesc = counterDesc;
		this.counterValue = counterValue;
		this.customParam = customParam;
	}

	public long getCounterId() {
		return counterId;
	}

	public void setCounterId(long counterId) {
		this.counterId = counterId;
	}

	public String getCounterDesc() {
		return counterDesc;
	}

	public void setCounterDesc(String counterDesc) {
		this.counterDesc = counterDesc;
	}

	public long getCounter_id() {
		return counterId;
	}

	public Map<String, Object> getCustomParam() {
		return customParam;
	}

	public void setCustomParam(Map<String, Object> customParam) {
		this.customParam = customParam;
	}

	public CounterView() {
	}

	public CounterView(long counterId, String counterDesc, Map<String, Object> customParam) {
		super();
		this.counterId = counterId;
		this.counterDesc = counterDesc;
		this.customParam = customParam;
	}

	@Override
	public String toString() {
		return "CounterView [counterId=" + counterId + ", counterDesc=" + counterDesc + ", counterValue=" + counterValue
				+ ", customParam=" + customParam + "]";
	}

}
