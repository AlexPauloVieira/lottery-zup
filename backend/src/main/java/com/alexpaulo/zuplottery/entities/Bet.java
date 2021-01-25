package com.alexpaulo.zuplottery.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bet")
public class Bet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int[] numbers;
	private Instant createdAt;
	private int typeDraw;
	private BetStatus status;

	public Bet() {
	}

	public Bet(Long id, BetStatus status, Instant createdAt, int qtdNum, int maxNum) {
		super();
		this.id = id;
		this.numbers = drawNumbers(qtdNum, maxNum);
		this.typeDraw = qtdNum;
		this.createdAt = createdAt;
		this.status = status;
	}

	private int[] drawNumbers(int qtdNum, int numMax) {
		int[] lottery = new int[qtdNum];
		int randomNum;
			for (int i = 0; i < qtdNum; i++) {
				randomNum = (int) (Math.random() * numMax+1);
				for (int x = 0; x < i; x++) {
					if (lottery[x] == randomNum || lottery[x] == 0) {
						randomNum = (int) (Math.random() * numMax+1);
						x = -1;
				}}
				lottery[i] = randomNum;
			}
		return lottery;
	}

	public Long getId() {
		return id;
	}
	

	public int getTypeDraw() {
		return typeDraw;
	}

	public void setTypeDraw(int typeDraw) {
		this.typeDraw = typeDraw;
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


	public BetStatus getStatus() {
		return status;
	}

	public void setIsWon(BetStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bet other = (Bet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}