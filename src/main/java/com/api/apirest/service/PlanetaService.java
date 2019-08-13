package com.api.apirest.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.api.apirest.model.PlanetaDTO;
import com.api.apirest.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	
	private RestTemplate restTemplate;
	
	public static final String URL_API_STAR_WARS = "https://swapi.co/api/planets/";
	
	
	public PlanetaDTO insertPlaneta(PlanetaDTO planeta) {
		return repository.save(planeta);
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			System.out.println("ERRO AO REMOVER O PLANETA");
			e.printStackTrace();
		}
	}
	
	public List<PlanetaDTO> getAll(){
		return repository.findAll();
	}
	
	public PlanetaDTO getById(Long id){
		Optional<PlanetaDTO> opt = repository.findById(id);
		return opt.get();
	}
	
	public List<PlanetaDTO> getByNome(String nome){
		return repository.findByName(nome);
	}
	
	public Integer getQuantidade(Long id) {
		try {
			restTemplate = new RestTemplate();
			String url = "URL_API_STAR_WARS"+id;
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        ResponseEntity<PlanetaDTO> planeta = restTemplate.exchange(url, HttpMethod.GET,entity,new ParameterizedTypeReference<PlanetaDTO>(){});
	        return planeta.getBody().getFilms().size();
			
		} catch (Exception e) {
			return null;
		}
		
	}
}
