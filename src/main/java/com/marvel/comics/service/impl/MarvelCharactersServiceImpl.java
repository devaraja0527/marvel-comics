package com.marvel.comics.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.marvel.comics.config.MarvelApiConfig;
import com.marvel.comics.exception.BaseException;
import com.marvel.comics.exception.EventFailedException;
import com.marvel.comics.model.Character;
import com.marvel.comics.model.DataObject;
import com.marvel.comics.model.MarvelAPIResponseWrapper;
import com.marvel.comics.service.MarvelCharactersService;
import com.marvel.comics.utils.CommonUtils;

@Service
public class MarvelCharactersServiceImpl implements MarvelCharactersService {

	private static final Logger logger = LogManager.getLogger(MarvelCharactersServiceImpl.class);

	private static final String ENGLISH = "ENGLISH";

	@Autowired
	MarvelApiConfig marvelApiConfig;

	@Autowired
	@Qualifier("marvelApiRestTemplate")
	RestTemplate restTemplate;

	@Autowired
	CommonUtils commonUtils;

	@Autowired
	@Qualifier("jsonParser")
	JSONParser jsonParser;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public List<Long> getAllCharactersIds() throws BaseException {

		List<Long> list = new ArrayList<Long>();
		try {
			JSONArray dataArrayFromFile = (JSONArray) jsonParser.parse(commonUtils.readDatatoFile());
			Iterator<JSONObject> iterator = dataArrayFromFile.iterator();

			while (iterator.hasNext()) {

				JSONObject object = iterator.next();
				list.add((Long) object.get("id"));
			}

		} catch (IOException | ParseException e) {
			throw new EventFailedException(e.getMessage());
		}

		return list;
	}

	@Override
	public Character getCharactersById(Long characterId) throws BaseException {

		Character character = null;
		ResponseEntity<MarvelAPIResponseWrapper> responseEntity = null;
		try {

			responseEntity = restTemplate.exchange(
					commonUtils.getMarvelAPIUrl(marvelApiConfig.getGetPath() + "/" + characterId), HttpMethod.GET, null,
					MarvelAPIResponseWrapper.class);

			DataObject dataOBJ = responseEntity.getBody().getData();

			List<Character> list = dataOBJ.getResults();

			character = list.get(0);

			logger.trace(responseEntity.getBody());

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return character;
	}

	@Override
	public Character getTranslatedCharectersById(Long characterId, String language) throws BaseException {

		Character character = null;
		try {
			character = this.getCharactersById(characterId);
			if (StringUtils.isNotBlank(character.getDescription())) {

				TranslationResult translationResult = commonUtils.getTranslatedResult(character.getDescription(),
						commonUtils.getLanguage(ENGLISH), commonUtils.getLanguage(language));

				character.setDescription(translationResult.getTranslations().toString());
			} else {

				logger.warn("Empty Descrption Found for the Character!!");
			}
		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
		return character;
	}

	@Override
	public void saveMarvelCharecterstoFile() throws BaseException {
		int offsetVal = 0;
		int limit = 100;

		try {
			JSONArray ja = new JSONArray();
			for (; offsetVal <= 300; offsetVal = (offsetVal + limit)) {

				ResponseEntity<String> responseEntity = restTemplate.exchange(
						commonUtils.getMarvelAPIUrlWithLimit(marvelApiConfig.getGetPath(), limit, offsetVal),
						HttpMethod.GET, null, String.class);

				JSONObject json = (JSONObject) jsonParser.parse(responseEntity.getBody());
				JSONObject dataOBJ = (JSONObject) json.get("data");
				JSONArray array = (JSONArray) dataOBJ.get("results");
				for (int i = 0; i < array.size(); i++) {
					ja.add(array.get(i));
				}

			}
			logger.trace(ja);
			commonUtils.writeDatatoFile(ja.toJSONString());
		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
	}

}
