package com.marvel.comics.service;

import java.util.List;

import com.marvel.comics.exception.BaseException;
import com.marvel.comics.model.Character;

public interface MarvelCharactersService {

	public List<Long> getAllCharactersIds() throws BaseException;;

	public Character getCharactersById(Long characterId) throws BaseException;;

	public Character getTranslatedCharectersById(Long characterId, String language) throws BaseException;

	public void saveMarvelCharecterstoFile() throws BaseException;
}
