package tk.Project1.server;

import java.net.*;

import tk.Project1.server.Server.SocketHandler;

public class ClientHandler {
	private SocketHandler handler;

	public ClientHandler(SocketHandler socketHandler) {
		this.handler = socketHandler;
	}

	public Socket getSocket() {
		return handler.getSocket();
	}

	public void sendMessage(short messageType, String message) {
		handler.send(messageType, message.getBytes());
	}
}
