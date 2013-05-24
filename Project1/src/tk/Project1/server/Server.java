package tk.Project1.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	final int defaultPort = 7458;
	int port;
	boolean isRunning;
	ServerSocket serverSocket;
	List<ClientHandler> clientHandler;

	public Server() {
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Server(int port) {
		this.port = port;
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPort() {
		return serverSocket.getLocalPort();
	}

	public InetAddress getInetAddress() {
		return serverSocket.getInetAddress();
	}

	protected synchronized List<ClientHandler> getClientHandler() {
		return clientHandler;
	}

	private void init() throws Exception {
		serverSocket = new ServerSocket(defaultPort);
		new ConnectionListener().start();
	}

	public void run() {
		isRunning = true;
		while (isRunning) {

		}
	}

	public void sendMessageToAllClients(short messageType, String message) {
		for (int i = 0; i < clientHandler.size(); i++) {
			clientHandler.get(i).sendMessage(messageType, message);
		}
	}

	class ConnectionListener extends Thread {
		public ConnectionListener() {

		}

		public void run() {

			while (isRunning) {
				try {
					Socket socket = serverSocket.accept();
					SocketHandler handler = new SocketHandler(socket);
					getClientHandler().add(new ClientHandler(handler));
					handler.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	class SocketHandler extends Thread {
		Socket socket;
		ClientHandler clientHandler;
		PrintWriter printWriter;
		BufferedReader bufferedReader;
		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;

		public SocketHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				dataInputStream = new DataInputStream(socket.getInputStream());
				printWriter = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				dataOutputStream = new DataOutputStream(
						socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (isRunning) {
				try {
					handleInput();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void setClientHandler(ClientHandler clientHandler) {
			this.clientHandler = clientHandler;
		}

		public Socket getSocket() {
			return socket;
		}

		public void handleInput() throws Exception {
			if (dataInputStream.available() > 1) {
				short messageType = dataInputStream.readShort();
				if (messageType == 0) {
					System.out.println(dataInputStream.readUTF());
				} else if (messageType == 1) {

				} else if (messageType == 2) {

				} else if (messageType == 3) {

				} else if (messageType == 4) {

				} else if (messageType == 5) {

				} else if (messageType == 6) {

				} else if (messageType == 7) {

				} else if (messageType == 8) {

				}
			}
		}

		public void send(short messageType, byte[] bytes) {
			try {

				dataOutputStream.writeShort(messageType);

				if (messageType == Message.TEXT)
					dataOutputStream.writeUTF(new String(bytes));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
