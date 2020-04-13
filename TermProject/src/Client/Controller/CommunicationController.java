package Client.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import Client.Model.Course;

//
public class CommunicationController {
	
	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	
	
	public CommunicationController(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void CommunicateWithServer() {
		String response = "";
		while(true) {
			try {
				//send a number to tell the server what action to perform
				response = socketIn.readLine();
				//send response to where its needed in the client package
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**public static void main(String[] args) throws IOException  {
		CommunicationController aClient = new CommunicationController("localhost", 8099);
		aClient.CommunicateWithServer();
	}
	*/
}
