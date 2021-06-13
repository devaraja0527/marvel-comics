package com.marvel.comics;

import java.util.ArrayList;
import java.util.List;

import com.marvel.comics.model.Character;
import com.marvel.comics.model.DataObject;
import com.marvel.comics.model.Image;
import com.marvel.comics.model.MarvelAPIResponseWrapper;

public class CommonUtilForTest {

	public MarvelAPIResponseWrapper getMarvelAPIResponseWrapperTESTOBJ() {

		MarvelAPIResponseWrapper marvelAPIResponseWrapper = new MarvelAPIResponseWrapper();
		marvelAPIResponseWrapper.setCode(200);
		marvelAPIResponseWrapper.setStatus("OK");
		marvelAPIResponseWrapper.setData(getDataObjectTestOBJ());
		return marvelAPIResponseWrapper;
	}

	private DataObject getDataObjectTestOBJ() {
		List<Character> list = new ArrayList<Character>();
		list.add(getCharacterTESTOBJ());
		DataObject dataObj = new DataObject();
		dataObj.setResults(list);
		return dataObj;
	}

	private Character getCharacterTESTOBJ() {
		Character character = new Character();
		character.setId(1000);
		character.setName("test-name");
		character.setDescription("test-desc");
		character.setThumbnail(getImageTestOBJ());
		return character;
	}

	private Image getImageTestOBJ() {
		Image img = new Image();
		img.setExtension("test-ex");
		img.setPath("rnadom-path");
		return img;
	}

}
