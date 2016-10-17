package com.company.util;

import com.google.common.base.Strings;
import com.google.gson.Gson;

public class Request {

	private static Gson gson = new Gson();
	
	private String requestId;
	private int serviceId;
	private String name;
	private String message;
	
	public String getRequestId() {
		return requestId;
	}
	public Request setRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}
	public int getServiceId() {
		return serviceId;
	}
	public Request setServiceId(int serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getName() {
		return name;
	}
	public Request setName(String name) {
		this.name = name;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public Request setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public static Request create(String json) {
		if (!Strings.isNullOrEmpty(json)) {
			return gson.fromJson(json, Request.class);
		}
		return null;
	}
	
	public String toJson() {
		return gson.toJson(this);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
}
