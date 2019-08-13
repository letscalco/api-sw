package com.api.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apirest.model.PlanetaDTO;

public interface PlanetaRepository extends JpaRepository<PlanetaDTO, Long>{

	List<PlanetaDTO> findByName(String nome);
	
	List <PlanetaDTO> findAll();
	
	Optional<PlanetaDTO> findById(Long id);
	
	
}
