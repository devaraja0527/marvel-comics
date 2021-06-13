package com.marvel.comics.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character implements Serializable {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("description")
    private String description;
	
	@JsonProperty("thumbnail")
    private Image thumbnail;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Image getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", description=" + description + ", thumbnail=" + thumbnail
				+ "]";
	}
    
	

}
