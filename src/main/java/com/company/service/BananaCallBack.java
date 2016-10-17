package com.company.service;

import com.company.util.Request;

public interface BananaCallBack {
	
	// 服务端发送消息给客户端
	void send(Request request) throws Exception;
	
}
