package dev.ollyfallows.mmo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkEngine {
	
	public static final int PORT = 9001;
	public static final String HOSTNAME = "ollyfallows.com";
	
	private static Socket connection;
	private static PrintWriter out;
	private static BufferedReader in;
	
	public NetworkEngine() {
		try {
			connection = new Socket(HOSTNAME, PORT);
			out = new PrintWriter(connection.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMsg() throws IOException {
		return in.readLine();
	}
	public static void sendMsg(String str) {
		out.print(str);
	}
}
