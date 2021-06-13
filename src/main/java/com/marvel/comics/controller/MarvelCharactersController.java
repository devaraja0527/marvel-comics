package com.marvel.comics.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.comics.exception.EventFailedException;
import com.marvel.comics.model.Character;
import com.marvel.comics.service.MarvelCharactersService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "marvel-characters")
public class MarvelCharactersController implements MarvelCharectersApi {

	private static final Logger logger = LogManager.getLogger(MarvelCharactersController.class);

	@Autowired
	private MarvelCharactersService marvelGetCharactersService;

	@Override
	public ResponseEntity<List<Long>> getAllCharactersIds() {
		List<Long> list = null;
		try {
			logger.trace("Get All Charecters Request Received!");

			list = marvelGetCharactersService.getAllCharactersIds();

			logger.trace("Get All Charecters Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Character> getCharactersById(@PathVariable("characterId") Long characterId) {
		Character data = null;
		try {

			logger.trace("Get Charecters By Id Request Received!");

			data = marvelGetCharactersService.getCharactersById(characterId);

			logger.trace("Get Charecters Charecters By Id Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Character> getTranslatedCharectersById(@PathVariable("characterId") Long characterId,
			@RequestParam("language") String language) {

		Character data = null;
		try {

			logger.trace("Get Charecters By Id With Language Translation Request Received!");

			data = marvelGetCharactersService.getTranslatedCharectersById(characterId, language);

			logger.trace("Get Charecters By Id With Language Translation Request Completed!");

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
