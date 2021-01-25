package com.alexpaulo.zuplottery.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexpaulo.zuplottery.DTO.GamblerDTO;
import com.alexpaulo.zuplottery.services.GamblerService;

@RestController
@RequestMapping(value = "/gamblers")
public class GamblerController {

	@Autowired
	private GamblerService service;
	
	@GetMapping
	public ResponseEntity<List<GamblerDTO>> findAll(){
		List<GamblerDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<GamblerDTO> insert(@RequestBody GamblerDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@PostMapping(value = "/newbet/{qtdDraw}/{gamblerId}")
	public ResponseEntity<GamblerDTO> insertBet(@PathVariable Long gamblerId, GamblerDTO dto, @PathVariable int qtdDraw){
		dto = service.insertBet(gamblerId, dto, qtdDraw);
		return ResponseEntity.ok().body(dto);
	}
		
}
