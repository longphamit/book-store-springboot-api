package com.web.bookstore.dto;

import java.io.Serializable;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public class MessageDTO implements Serializable{
	public static final String MESSAGE="message";
	public static final String STATUS="status";
	public static final String DATA="data";
	private JSONObject jsonReturn;
	private String result;
	public MessageDTO() {
		jsonReturn= new JSONObject();
	}
	public void createReturn(String message, boolean status, JSONArray data) {
		jsonReturn.put(MESSAGE,message);
		jsonReturn.put(STATUS, status);
		jsonReturn.put(DATA, data);
		this.result=jsonReturn.toString();
	}
	public String getResult() {
		return result;
	}
	
	
}
