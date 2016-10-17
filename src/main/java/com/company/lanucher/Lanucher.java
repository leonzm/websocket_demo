package com.company.lanucher;

import com.company.server.WebSocketServer;

public class Lanucher {

	public static void main(String[] args) throws Exception {
		// 启动WebSocket
		new WebSocketServer().run(WebSocketServer.WEBSOCKET_PORT);
	}
	
}
