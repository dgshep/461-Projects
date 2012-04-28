package edu.uw.cs.cse461.sp12.OS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;


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
			
		}
	}

	
	
//	private byte[] address;
//	private User user;
//	private boolean loggedIn;
//	private Socket socket;
//	private BufferedReader input;
//	private PrintWriter output;
//	private boolean listening;
//	
//	/*
//	 * Canned responses
//	 */
//	private static final Message LOGIN_SUCCESS_MESSAGE = 
//			new LoginMessage(true);
//	private static final Message LOGIN_FAILURE_MESSAGE =
//			new LoginMessage(false);
//	private static final Message LOGOUT_MESSAGE = 
//			new LogoutMessage();
//	private static final Message CREATE_USER_SUCCESS_MESSAGE =
//			new CreateUserMessage(true);
//	private static final Message CREATE_USER_FAILURE_MESSAGE =
//			new CreateUserMessage(false);
//
//	private static ErrorLogger logger = ErrorLogger.getInstance();
//	
//	/**
//	 * Creates a new ServerConnection on the given socket
//	 * @param socket the socket to communicate with
//	 * @param gameManager the game manager for the back end logic
//	 */
//	public ServerConnection(Socket socket) {
//		this.socket = socket;
//		address = socket.getInetAddress().getAddress();
//		loggedIn = false;
//		listening = true;
//		try {
//			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			output = new PrintWriter(
//						new BufferedWriter(
//							new OutputStreamWriter(socket.getOutputStream())),
//						true);
//		} catch (IOException ioe) {
//			logger.logException(ioe);
//		}
//	}
//	
//	/**
//	 * Listen on the socket, reading from and writing to the user
//	 */
//	@Override
//	public void run() {
//		while (listening) {
//			try {
//				// Listen for input - blocks until a message is received
//				Message message = Message.parseMessage(input);
//				interpretMessage(message);
//			} catch (InvalidMessageException ime) {
//				logger.logInvalidMessage(ime);
//				// An invalid message will just be dropped, it is up to the phone
//				// to send a valid message
//			} catch (Exception e) {
//				// "Last line of defense"
//				logger.logException(e);
//			}
//		}
//		if (user != null) {
//			if(user.getUserState().equals(UserState.IN_MATCHMAKING)) {
//				user.getMatchmakingGame().removeUser(user);
//				user.clearMatchmakingGame();
//			}
//			if(user.getUserState().equals(UserState.WAITING_TO_ACCEPT_GAME)) {
//				user.getMatchmakingGame().acceptGame(user, false);
//				user.clearMatchmakingGame();
//			}
//		}
//		try {
//			socket.close();
//		} catch (IOException e) {
//			logger.logException(e);
//		}
//	}
//	
//	/**
//	 * Interprets the message - splitting behavior based on the type of message
//	 * and performing associated actions
//	 * @param message the message to interpret
//	 * @throws InvalidMessageException if the message is not properly 
//	 * 		formatted for the given type
//	 */
//	private void interpretMessage(Message message) throws InvalidMessageException {
//		logger.logMessage(message, false);
//		switch (message.getMessageType()) {
//			case LOGIN:
//				LoginMessage loginMessage = (LoginMessage) message;
//				String username = loginMessage.getUsername();
//				String password = loginMessage.getPassword();
//				user = RealUser.login(this, username, password);
//				if (user != null) {
//					loggedIn = true;
//					updatePhone(LOGIN_SUCCESS_MESSAGE);
//				} else {
//					updatePhone(LOGIN_FAILURE_MESSAGE);
//				}
//				break;
//			case LOGOUT:
//				if (loggedIn) {
//					user.logout();
//					loggedIn = false;
//					updatePhone(LOGOUT_MESSAGE);
//				}
//				break;
//			case CLOSE_CONNECTION:
//				listening = false;
//				break;
//			case CREATE_USER:
//				CreateUserMessage createUserMessage = (CreateUserMessage) message;
//				String createUsername = createUserMessage.getUsername();
//				String createPassword = createUserMessage.getPassword();
//				String createFirstName = createUserMessage.getFirstName();
//				String createLastName = createUserMessage.getLastName();
//				String createEmail = createUserMessage.getEmailAddress();
//				boolean success =RealUser.createUser(this,
//													 createUsername, 
//													 createPassword, 
//													 createFirstName, 
//													 createLastName, 
//													 createEmail);
//				if (success) {
//					updatePhone(CREATE_USER_SUCCESS_MESSAGE);
//				} else {
//					updatePhone(CREATE_USER_FAILURE_MESSAGE);
//				}
//				break;
//			default:
//				if(user != null) {
//					user.updatePlayer(message);
//				} else {
//					throw new InvalidMessageException();
//				}
//				break;
//		}
//				
//	}
//	
//	/**
//	 * @return returns the ip address of this connection
//	 */
//	public byte[] getAddress() {
//		return address;
//	}
//	
//	@Override
//	public int hashCode() {
//		return socket.hashCode() + address.hashCode();
//	}
//	
//	/**
//	 * Sends a message to the phone connected on the other end of this connection
//	 * @param message the message to send
//	 */
//	public synchronized void updatePhone(Message message) {
//		logger.logMessage(message, true);
//		output.println(message.getSendableMessage());
//		output.flush();
//	}
}

