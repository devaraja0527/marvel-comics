package com.marvel.comics.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marvel.comics.exception.EventFailedException;
import com.marvel.comics.model.Character;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface MarvelCharectersApi {

	@ApiOperation(value = "Retrieves All character ids from JSON file", nickname = "getAllCharactersIds", notes = "Retrieves All character ids from JSON file", tags = {
			"marvel-characters" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response"),
			@ApiResponse(code = 400, message = "Bad request EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 401, message = "Unauthorised EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 403, message = "Forbidden EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 404, message = "Entity not found EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 405, message = "Method Not Allowed EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 406, message = "Not Acceptable EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 429, message = "Too Many Requests EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 500, message = "An unexpected server EventFailedException occurred", response = EventFailedException.class),
			@ApiResponse(code = 503, message = "Service unavailable EventFailedException", response = EventFailedException.class) })
	@GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<Long>> getAllCharactersIds();

	@ApiOperation(value = "Retrieves character by its id from Marvel API", nickname = "getCharactersById", notes = "Retrieves character by its id from Marvel API", response = Character.class, tags = {
			"marvel-characters" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = Character.class),
			@ApiResponse(code = 400, message = "Bad request EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 401, message = "Unauthorised EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 403, message = "Forbidden EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 404, message = "Entity not found EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 405, message = "Method Not Allowed EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 406, message = "Not Acceptable EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 429, message = "Too Many Requests EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 500, message = "An unexpected server EventFailedException occurred", response = EventFailedException.class),
			@ApiResponse(code = 503, message = "Service unavailable EventFailedException", response = EventFailedException.class) })
	@GetMapping(value = "/characters/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Character> getCharactersById(
			@ApiParam(value = "Character Id", required = true) @PathVariable("characterId") Long characterId);

	@ApiOperation(value = "Retrieves character by and translated desc its id from Marvel API", nickname = "getTranslatedCharectersById", notes = "Retrieves character by and translated desc its id from Marvel API", response = Character.class, tags = {
			"marvel-characters" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = Character.class),
			@ApiResponse(code = 400, message = "Bad request EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 401, message = "Unauthorised EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 403, message = "Forbidden EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 404, message = "Entity not found EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 405, message = "Method Not Allowed EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 406, message = "Not Acceptable EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 429, message = "Too Many Requests EventFailedException", response = EventFailedException.class),
			@ApiResponse(code = 500, message = "An unexpected server EventFailedException occurred", response = EventFailedException.class),
			@ApiResponse(code = 503, message = "Service unavailable EventFailedException", response = EventFailedException.class) })
	@GetMapping(value = "/characters/{character-id}", params = "language", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Character> getTranslatedCharectersById(
			@ApiParam(value = "Character Id", required = true) @PathVariable("character-id") Long characterId,
			@ApiParam(value = "Language", required = true) @RequestParam(value = "language", required = true) String language);

}
