package br.com.apiRickAndMorty.response;

import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
public class CharacterAllResponse {

	private List<CharacterResponse> results;
	
}
