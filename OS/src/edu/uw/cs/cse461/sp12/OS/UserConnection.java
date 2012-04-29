package edu.uw.cs.cse461.sp12.OS;

import java.net.Socket;

public class UserConnection implements Runnable {

	Socket user;
	
	public UserConnection(Socket user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
