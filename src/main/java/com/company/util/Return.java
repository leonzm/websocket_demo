package com.company.util;

import java.util.HashMap;

import com.google.gson.Gson;

/**
 * 通用返回对象封装
 *
 */
public class Return extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 5558814018967387112L;
	
	private static Gson gson = new Gson();

	public enum Return_Fields {
		success, code, note
	}
	
	/************ Create ************/
	
	public static Return create() {
		return new Return();
	}
	
	public static Return create(String k, Object v) {
		return new Return().put(k, v);
	}
	
	/************ Success ************/
	public static Return SUCCESS(Integer code, String note) {
		Return pojo = new Return();
		pojo.put(Return_Fields.success.name(), true);
		pojo.put(Return_Fields.code.name(), code);
		pojo.put(Return_Fields.note.name(), note);
		return pojo;
	}
	
	public static Return SUCCESS(CODE code) {
		return SUCCESS(code.code, code.note);
	}
	
	/************ Fail ************/
	public static Return FAIL(Integer code, String note) {
		Return pojo = new Return();
		pojo.put(Return_Fields.success.name(), false);
		pojo.put(Return_Fields.code.name(), code);
		pojo.put(Return_Fields.note.name(), note);
		return pojo;
	}

	public static Return FAIL(CODE code) {
		return FAIL(code.code, code.note);
	}

	public static Return FAIL(CODE code, Exception e) {
		return FAIL(code.code, stacktrace(e));
	}
	
	/************ Getter Setter ************/
	public Boolean is_success() {
		return (Boolean) this.getOrDefault(Return_Fields.success.name(), false);
	}

	public Integer get_code() {
		return (Integer) this.getOrDefault(Return_Fields.code.name(), CODE.error.code);
	}

	public String get_note() {
		return (String) this.getOrDefault(Return_Fields.note.name(), "");
	}
	
	/************ Override ************/
	@Override
	public Return put(String k, Object v) {
		this.put(k, v);
		return this;
	}
	
	public Return add(String k, Object v) {
		this.put(k, v);
		return this;
	}
	
	public String toJson() {
		return gson.toJson(this);
	}
	
	@Override
	public String toString() {
		return this.toJson();
	}
	
	/************ Tool ************/
	
	/**
	 * 打印异常
	 * @param e
	 * @return
	 */
	private static String stacktrace(Throwable e) {
		StringBuilder stack_trace = new StringBuilder();
		while (e != null) {
			String error_message = e.getMessage();
			error_message = error_message == null ? "\r\n" : error_message.concat("\r\n");
			stack_trace.append(error_message);
			stack_trace.append("<br>");
			for (StackTraceElement string : e.getStackTrace()) {
				stack_trace.append(string.toString());
				stack_trace.append("<br>");
			}
			e = e.getCause();
		}
		return stack_trace.toString();
	}
	
}
