package com.org.counterservice.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "counter")
public class Counter {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long counterId;

    @Column
    @NotNull
    private long counterValue;
    
    @Column
    private String counterDesc;

	public long getCounterId() {
		return counterId;
	}

	public void setCounterId(long counterId) {
		this.counterId = counterId;
	}

	public long getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(long counterValue) {
		this.counterValue = counterValue;
	}

	public String getCounterDesc() {
		return counterDesc;
	}

	public void setCounterDesc(String counterDesc) {
		this.counterDesc = counterDesc;
	}

	@Override
	public String toString() {
		return "Counter [counterId=" + counterId + ", counterValue=" + counterValue + ", counterDesc=" + counterDesc
				+ "]";
	}

	public Counter(long counterId, @NotNull long counterValue, String counterDesc) {
		super();
		this.counterId = counterId;
		this.counterValue = counterValue;
		this.counterDesc = counterDesc;
	}
	public Counter() {
		super();
	}

}
