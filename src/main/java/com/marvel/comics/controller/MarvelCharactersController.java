package com.marvel.comics.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.comics.exception.EventFailedException;
import com.marvel.comics.model.Character;
import com.marvel.comics.service.MarvelCharactersService;

@RestController
public class MarvelCharactersController {

	private static final Logger logger = LogManager.getLogger(MarvelCharactersController.class);

	@Autowired
	private MarvelCharactersService marvelGetCharactersService;

	@GetMapping(path = "/characters", produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Long> getAllCharactersIds() {

		List<Long> list = null;

		try {
			logger.trace("Get All Charecters Request Received!");

			list = marvelGetCharactersService.getAllCharactersIds();

			logger.trace("Get All Charecters Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}

		return list;
	}

	@GetMapping(path = "/characters/{characterId}", produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Character getCharactersById(@PathVariable Long characterId) {
		Character data = null;
		try {

			logger.trace("Get Charecters By Id Request Received!");

			data = marvelGetCharactersService.getCharactersById(characterId);

			logger.trace("Get Charecters Charecters By Id Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return data;
	}

	@GetMapping(path = "/characters/{characterId}", params = "language", produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Character getTranslatedCharectersById(@PathVariable Long characterId, @RequestParam String language) {

		Character data = null;
		try {

			logger.trace("Get Charecters By Id With Language Translation Request Received!");

			data = marvelGetCharactersService.getTranslatedCharectersById(characterId, language);

			logger.trace("Get Charecters By Id With Language Translation Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return data;
	}
}
