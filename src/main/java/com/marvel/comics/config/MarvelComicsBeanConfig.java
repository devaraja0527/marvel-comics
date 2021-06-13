package com.marvel.comics.config;

import static springfox.documentation.builders.PathSelectors.regex;

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

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableConfigurationProperties({ IbmWatsonApiConfig.class })
@EnableSwagger2
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

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.marvel.comics.controller")).paths(regex("/public.*"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("\"Spring Boot REST API for Online Store\"").version("1.0.0").build();
	}

}
