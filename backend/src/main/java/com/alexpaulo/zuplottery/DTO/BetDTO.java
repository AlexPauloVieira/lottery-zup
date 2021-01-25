package com.alexpaulo.zuplottery.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.alexpaulo.zuplottery.entities.Bet;
import com.alexpaulo.zuplottery.entities.BetStatus;

public class BetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int[] numbers;
	private Instant createdAt;
	private int typeDraw;
	private BetStatus status;
	
	public BetDTO() {
	}
	
	public BetDTO(Long id, Instant createdAt, BetStatus status) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.status = status;
	}
	
	public BetDTO(Bet entity) {
		id = entity.getId();
		typeDraw = entity.getTypeDraw();
		numbers = entity.getNumbers();
		createdAt = entity.getCreatedAt();
		status = entity.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public int getTypeDraw() {
		return typeDraw;
	}

	public void setTypeDraw(int typeDraw) {
		this.typeDraw = typeDraw;
	}

	public BetStatus getStatus() {
		return status;
	}

	public void setStatus(BetStatus status) {
		this.status = status;
	}	
}
