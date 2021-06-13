package com.marvel.comics.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "ibmwatson")
@Validated
public class IbmWatsonApiConfig implements Serializable {

	private String url;
	
	private String apiKey;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "IbmWatsonApiConfig [url=" + url + ", apiKey=" + apiKey + "]";
	}
	
}
