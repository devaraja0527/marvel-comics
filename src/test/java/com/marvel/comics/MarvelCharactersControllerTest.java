package com.marvel.comics;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.marvel.comics.model.MarvelAPIResponseWrapper;
import com.marvel.comics.utils.CommonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
public class MarvelCharactersControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	@Qualifier("marvelApiRestTemplate")
	private RestTemplate marvelApiRestTemplate;

	@Mock
	CommonUtils commonUtils;

	@Mock
	TranslationResult result;

	private MarvelAPIResponseWrapper marvelAPIResponseWrapper = null;

	@Test
	public void getAllCharacterIdsTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getCharacterDetailsByIdTest() throws Exception {

		CommonUtilForTest commonUtilForTest = new CommonUtilForTest();
		marvelAPIResponseWrapper = commonUtilForTest.getMarvelAPIResponseWrapperTESTOBJ();

		ResponseEntity<MarvelAPIResponseWrapper> myEntity = new ResponseEntity<MarvelAPIResponseWrapper>(
				marvelAPIResponseWrapper, HttpStatus.OK);

		when(marvelApiRestTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<MarvelAPIResponseWrapper>>any())).thenReturn(myEntity);

		mvc.perform(MockMvcRequestBuilders.get("/characters/10000").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getCharacterDetailsByIdWithTranslationTest() throws Exception {

		CommonUtilForTest commonUtilForTest = new CommonUtilForTest();
		marvelAPIResponseWrapper = commonUtilForTest.getMarvelAPIResponseWrapperTESTOBJ();

		ResponseEntity<MarvelAPIResponseWrapper> myEntity = new ResponseEntity<MarvelAPIResponseWrapper>(
				marvelAPIResponseWrapper, HttpStatus.OK);

		when(marvelApiRestTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<MarvelAPIResponseWrapper>>any())).thenReturn(myEntity);

		when(commonUtils.getTranslatedResult(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(result);

		mvc.perform(MockMvcRequestBuilders.get("/characters/10000?language=hi").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
