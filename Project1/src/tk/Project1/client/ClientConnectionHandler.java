package tk.Project1.client;

import java.net.*;
import java.io.*;

public class ClientConnectionHandler extends Thread {
	Socket socket;
	Client client;

	public ClientConnectionHandler(Client client, Socket socket) {
		this.client = client;
		this.socket = socket;
	}

	public void run() {
		while(client.isRunning()){
			
		}
	}
	
}
