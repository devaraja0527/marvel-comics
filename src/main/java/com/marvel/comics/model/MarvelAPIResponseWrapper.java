package com.marvel.comics.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarvelAPIResponseWrapper implements Serializable {

	 @JsonProperty("code")
	 private int code;
	 
	 @JsonProperty("status")
	 private String status;
	 
	 @JsonProperty("data") 
	 private DataObject data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public DataObject getData() {
		return data;
	}

	public void setData(DataObject data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MarvelAPIResponseWrapper [code=" + code + ", status=" + status + ", data=" + data + "]";
	}
	 
	 
}
