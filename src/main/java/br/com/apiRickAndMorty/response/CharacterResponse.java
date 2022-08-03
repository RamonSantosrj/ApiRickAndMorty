package br.com.apiRickAndMorty.response;

import java.util.List;

import lombok.Data;

@Data
public class CharacterResponse {

	private int id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private Object location;
	private Object origin;
	private String image;
	private List<String> episode;
	private String url;
	private String created;
	
}
