package br.com.apiRickAndMorty.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.apiRickAndMorty.response.CharacterAllResponse;

@Service
public class RickyAndMortyClient {

	public static List<Object> getAll() {

		try {
			String url = "https://rickandmortyapi.com/api/character";
			RestTemplate restTemplate = new RestTemplate();
			List<Object> listaCharacter = (List<Object>) restTemplate.getForObject(url, Object.class);
			System.out.println(listaCharacter.toString());
			return listaCharacter;

		} catch (Exception e) {
			return null;
		}
	}

}
