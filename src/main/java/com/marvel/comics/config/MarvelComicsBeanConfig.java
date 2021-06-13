package com.marvel.comics.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;

@Configuration
@EnableConfigurationProperties({ IbmWatsonApiConfig.class })
public class MarvelComicsBeanConfig {

	@Autowired
	IbmWatsonApiConfig ibmWatsonApiConfig;

	@Bean
	@Qualifier("marvelApiRestTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	@Qualifier("ibmAuthenticatorBean")
	public Authenticator ibmAuthenticatorBean() {
		return new IamAuthenticator(ibmWatsonApiConfig.getApiKey());

	}

	@Bean
	@Qualifier("languagesMap")
	public Map<String, Locale> mongoTemplateMap() throws Exception {

		String[] languages = Locale.getISOLanguages();
		Map<String, Locale> localeMap = new HashMap<String, Locale>(languages.length);
		for (String language : languages) {
			Locale locale = new Locale(language);
			localeMap.put(locale.getDisplayLanguage().toUpperCase(), locale);
		}
		return localeMap;
	}

	@Bean
	@Qualifier("getJSONParserBean")
	public JSONParser getJSONParserBean() {
		return new JSONParser();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
