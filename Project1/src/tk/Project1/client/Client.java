package tk.Project1.client;

public class Client {
	boolean isRunning;
	ClientConnectionHandler connectionHandler;

	public Client() {
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() throws Exception {

	}

	public void run() {
		while (isRunning) {

		}
	}

	public boolean isRunning() {
		return isRunning;
	}
}
