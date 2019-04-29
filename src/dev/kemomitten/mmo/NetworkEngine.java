package dev.kemomitten.mmo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkEngine {
	
	private Socket connection;
	private PrintWriter out;
	private BufferedReader in;
	
	public NetworkEngine() {
		connect();
	}
	
	public boolean connect() {
		try {
			connection = new Socket("127.0.0.1", 9001);
			out = new PrintWriter(connection.getOutputStream());
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while(!in.ready()) {}
			Game.uid = in.readLine();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sendMsg(String str) {
		if (connection.isConnected()) {
			out.println(str);
			out.flush();
			return true;
		}
		return false;
	}
	
	public String getMsg() {
		try {
			return in.ready() ? in.readLine() : null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void disconnect() {
		try {
			connection.shutdownInput();
			connection.shutdownOutput();
			in.close();
			out.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
