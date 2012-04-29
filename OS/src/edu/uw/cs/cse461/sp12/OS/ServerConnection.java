package edu.uw.cs.cse461.sp12.OS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Manages a single user's connection to the server / back end logic
 */
public class ServerConnection implements Runnable {

	private ServerSocket connection;
	
	public ServerConnection(ServerSocket connection) {
		this.connection = connection;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!connection.isClosed()) {
			try {
				Socket newUser = connection.accept();
				UserConnection thread = new UserConnection(newUser);
				thread.run();
			} catch (IOException e) {}
			
		}
	}

}

