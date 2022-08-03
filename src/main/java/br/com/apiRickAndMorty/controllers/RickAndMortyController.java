package br.com.apiRickAndMorty.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import br.com.apiRickAndMorty.response.CharacterAllResponse;
import br.com.apiRickAndMorty.response.CharacterResponse;

@CrossOrigin
@Controller
public class RickAndMortyController {

	private static final String ENDPOINT = "api/rickandmorty/";

	@RequestMapping(value = ENDPOINT + "{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable int id) {
		try {

			String url = "https://rickandmortyapi.com/api/character/" + id;
			RestTemplate restTemplate = new RestTemplate();
			Object characterResponse = restTemplate.getForObject(url, Object.class);
			System.out.println(characterResponse.toString());

			return ResponseEntity.status(HttpStatus.OK).body(characterResponse);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<List<CharacterAllResponse>> getAll() {
		try {

			String url = "https://rickandmortyapi.com/api/character";
			RestTemplate restTemplate = new RestTemplate();
			CharacterAllResponse characterAllResponse = restTemplate.getForObject(url, CharacterAllResponse.class);
			System.out.println(characterAllResponse.toString());

			return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(characterAllResponse));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
