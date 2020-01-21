import java.net.*;
import java.io.*;
import java.util.Date;

public class SimpleServer {

	private ServerSocket sock = null;

	public SimpleServer(int port) throws IOException {

		sock = new ServerSocket(port);
		System.out.println("Listening for connection on port " + this.sock.getLocalPort() + " ...");

		while (true) {
			try (Socket temp = sock.accept()) {
				// read http get request from client
				// prepare an http response
				// send that response
				// close

				// lines 23-30 show how to read the HTTP request from client socket

				BufferedReader reader = new BufferedReader(new InputStreamReader(temp.getInputStream()));
				String line = reader.readLine();

				try {
					while (!line.isEmpty()) {
						System.out.println(line);
						line = reader.readLine();
					}
				} finally {
					//Date today = new Date();
					String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Praj loves contributing to ScoreLab";
					temp.getOutputStream().write(httpResponse.getBytes("UTF-8"));
				}

			}
			System.exit(0);
		}
	}

	public static void main(String[] args) throws IOException {
//A HTTP Server I created that listens upon a TCP Port that is provided via passing in the value to the constructor when an object of this class is instantiated.
//Then a session between the client and server sockets are created, in which I read and print out the GET Request Details 
//It then prints out the current date and terminates the program
		new SimpleServer(8080);
	}

}
