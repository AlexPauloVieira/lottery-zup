package com.alexpaulo.zuplottery.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alexpaulo.zuplottery.entities.Gambler;

public class GamblerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private int totalGames;
	private List<BetDTO> bets = new ArrayList<>();

	public GamblerDTO() {
	}

	public GamblerDTO(Long id, String email, List<BetDTO> bets) {
		super();
		this.id = id;
		this.email = email;
		this.bets = bets;
	}

	public GamblerDTO(Gambler entity) {
		id = entity.getId();
		email = entity.getEmail();
		totalGames = entity.getQtdGames();
		bets = entity.getGames().stream().map(x -> new BetDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	public List<BetDTO> getBets() {
		return bets;
	}

}
