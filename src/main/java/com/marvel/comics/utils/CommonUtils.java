package com.marvel.comics.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.marvel.comics.config.IbmWatsonApiConfig;
import com.marvel.comics.config.MarvelApiConfig;
import com.marvel.comics.exception.EventFailedException;

@Service
public class CommonUtils {

	private final String DATE_FORMAT = "yyyy-MM-dd";

	private final String FILE_PATH = "src/main/resources/marvel-characters.json";

	@Autowired
	MarvelApiConfig marvelApiConfig;

	@Autowired
	IbmWatsonApiConfig ibmWatsonApiConfig;

	@Autowired
	@Qualifier(value = "languagesMap")
	private Map<String, Locale> localeMap;

	@Autowired
	@Qualifier("ibmAuthenticatorBean")
	Authenticator authenticator;

	@Autowired
	@Qualifier("getJSONParserBean")
	JSONParser jsonParser;

	public String getMarvelAPIUrl(final String uriPath) {

		long timeStamp = System.currentTimeMillis();

		return (marvelApiConfig.getUrl() + uriPath + "?ts=" + timeStamp + "&apikey=" + marvelApiConfig.getPublicKey()
				+ "&hash=" + getMarvelHashKey(timeStamp));
	}

	public String getMarvelAPIUrlWithLimit(final String uriPath, long limitVal, long offsetVal) {

		long timeStamp = System.currentTimeMillis();

		return (marvelApiConfig.getUrl() + uriPath + "?limit=" + limitVal + "&offset=" + offsetVal + "&ts=" + timeStamp
				+ "&apikey=" + marvelApiConfig.getPublicKey() + "&hash=" + getMarvelHashKey(timeStamp));
	}

	private String getMarvelHashKey(long timeStamp) {
		return DigestUtils.md5Hex(timeStamp + marvelApiConfig.getPrivateKey() + marvelApiConfig.getPublicKey());
	}

	public TranslationResult getTranslatedResult(String messagetoTranslate,

			String sourceLanguage, String targetLanguage) throws Exception {

		String date = new SimpleDateFormat(DATE_FORMAT).format(new Date());

		LanguageTranslator service = new LanguageTranslator(date, authenticator);
		service.setServiceUrl(ibmWatsonApiConfig.getUrl());

		TranslateOptions translateOptions = new TranslateOptions.Builder().addText(messagetoTranslate)
				.source(sourceLanguage).target(targetLanguage).build();

		return service.translate(translateOptions).execute().getResult();

	}

	public String getLanguage(String language) {

		if (null != language && 2 == language.length()) {
			return language;
		} else {
			return localeMap.get(language).toString();
		}
	}

	public void writeDatatoFile(String data) {
		try {
			FileWriter file = new FileWriter(FILE_PATH);
			file.write(data);
			file.close();
		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
	}

	public FileReader readDatatoFile() {
		try {
			return new FileReader(FILE_PATH);

		} catch (Exception e) {
			throw new EventFailedException(e.getMessage());
		}
	}

}
