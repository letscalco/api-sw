package com.api.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.apirest.model.PlanetaDTO;
import com.api.apirest.service.PlanetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/planeta")
@Api(value = "planeta", tags = { "PLANETAS DO FILME STAR WARS" })
public class StarWarsController {

	@Autowired
	private PlanetaService service;
	
	
	@ApiOperation(value = "Busca todos os planetas",response = PlanetaDTO[].class)
	@GetMapping("/buscar")
	public List<PlanetaDTO> getAll() {
		return service.getAll();
	}
	
	@ApiOperation(value = "Busca planetas pelo Id",response = PlanetaDTO.class)
	@GetMapping("/buscar/id/{id}")
	public PlanetaDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@ApiOperation(value = "Busca planetas pelo nome",response = PlanetaDTO[].class)
	@GetMapping("/buscar/nome/{nome}")
	public List<PlanetaDTO> getByName(@PathVariable String nome) {
		return service.getByNome(nome);
	}
	
	@ApiOperation(value = "Grava planeta")
	@PostMapping("/gravar")
	public ResponseEntity <PlanetaDTO> save(@RequestBody PlanetaDTO planeta){
		return ResponseEntity.ok(service.insertPlaneta(planeta));
	}
	
	@ApiOperation(value = "Remove planeta por Id")
	@DeleteMapping("/remover/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@ApiOperation(value = "Busca planetas pelo Id",response = PlanetaDTO.class)
	@GetMapping("/buscarQuantidade/{id}")
	public Integer getQuantidadeFilmes(@PathVariable Long id) {
		return service.getQuantidade(id);
	}
	
	 
	
	
}
