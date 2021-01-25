package com.alexpaulo.zuplottery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexpaulo.zuplottery.DTO.BetDTO;
import com.alexpaulo.zuplottery.entities.Bet;
import com.alexpaulo.zuplottery.entities.BetStatus;
import com.alexpaulo.zuplottery.repositories.BetRepository;

@Service
public class BetService {
	
	@Autowired
	private BetRepository repository;
		
	@Transactional(readOnly = true)
	public List<BetDTO> findAll() {
		List<Bet> list = repository.findAll();
		return list.stream().map(x -> new BetDTO(x)).collect(Collectors.toList());
				
	}
	
	@Transactional
	public BetDTO insert(BetDTO dto) {
		Bet bet= new Bet(null, BetStatus.PENDING, Instant.now(), 6, 60);
		bet = repository.save(bet);
		return new BetDTO(bet);
	}
		
}