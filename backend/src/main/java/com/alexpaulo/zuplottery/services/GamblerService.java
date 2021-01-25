package com.alexpaulo.zuplottery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexpaulo.zuplottery.DTO.GamblerDTO;
import com.alexpaulo.zuplottery.entities.Bet;
import com.alexpaulo.zuplottery.entities.BetStatus;
import com.alexpaulo.zuplottery.entities.Gambler;
import com.alexpaulo.zuplottery.repositories.BetRepository;
import com.alexpaulo.zuplottery.repositories.GamblerRepository;

@Service
public class GamblerService {

	@Autowired
	private GamblerRepository repository;
	
	@Autowired
	private BetRepository betRepository;
	
	@Transactional(readOnly = true)
	public List<GamblerDTO> findAll() {
		List<Gambler> list = repository.findAll();
		return list.stream().map(x -> new GamblerDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public GamblerDTO insert(GamblerDTO dto) {
		Gambler Gambler= new Gambler(null, dto.getEmail());
		
		Gambler = repository.save(Gambler);
		
		return new GamblerDTO(Gambler);
	}
	
	
	@Transactional
	public GamblerDTO insertBet(Long id, GamblerDTO dto, int qtdDraw) {
		Gambler entity = repository.getOne(id);
		int maxNumber = 60;
		Bet bet = new Bet(null, BetStatus.PENDING, Instant.now(), qtdDraw, maxNumber);
		bet = betRepository.save(bet);
		entity.getGames().add(bet);
		entity = repository.save(entity);
		return new GamblerDTO(entity);
	}
	
}
