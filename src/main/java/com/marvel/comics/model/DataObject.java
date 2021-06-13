package com.marvel.comics.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataObject implements Serializable {

	@JsonProperty("results") 
	private List<Character> results;

	public List<Character> getResults() {
		return results;
	}

	public void setResults(List<Character> results) {
		this.results = results;
	}
	
}
