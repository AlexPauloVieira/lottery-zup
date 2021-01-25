package com.alexpaulo.zuplottery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexpaulo.zuplottery.entities.Gambler;

public interface GamblerRepository extends JpaRepository<Gambler, Long> {

	Gambler findByEmail(String email);
}
