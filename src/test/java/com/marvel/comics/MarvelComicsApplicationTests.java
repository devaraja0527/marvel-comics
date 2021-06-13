package com.marvel.comics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marvel.comics.service.MarvelCharactersService;

@SpringBootTest
class MarvelComicsApplicationTests {

	@Autowired
	MarvelCharactersService mMarvelCharactersService;

	@Test
	void contextLoads() {
		mMarvelCharactersService.saveMarvelCharecterstoFile();
	}

}
