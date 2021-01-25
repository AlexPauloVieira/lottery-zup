package com.alexpaulo.zuplottery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexpaulo.zuplottery.entities.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {

}
