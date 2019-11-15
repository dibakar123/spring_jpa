package com.model;

import java.util.List;

public class RestResponse {
private int code;
private String message;
private List<User> data;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<User> getData() {
	return data;
}
public void setData(List<User> data) {
	this.data = data;
}

}
