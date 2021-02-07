package com.syritx.Main;

import java.io.*;
import java.net.*;

public class CommunicationCenter extends Thread {
	
	ServerSocket server;
	Socket ESP;
	
	@Override
	public void run() {
		
		try {
			server = new ServerSocket(6060);
		}
		catch (IOException e) {}
		
		while (true) {
			
			try {
				ESP = server.accept();
			} 
			catch (IOException e1) {}
			
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {}
			System.out.println("client connected");
		}
	}
	
	public void sendToESP(String message) throws IOException {
		PrintWriter writer = new PrintWriter(ESP.getOutputStream(), true);
		writer.println(message);
	}
}
