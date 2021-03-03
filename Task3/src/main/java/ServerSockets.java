import java.net.*;
import java.io.*;
//package com.vogella.junit5;

public class ServerSockets {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(Integer port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            } else {
                out.println("unrecognised greeting");
            }
        } catch (IOException err) {
            out.println(err);
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException err) {
            out.println(err);
        }
    }

    public static void main(String[] args) {
        ServerSockets server = new ServerSockets();
        server.start(8080);
    }
}