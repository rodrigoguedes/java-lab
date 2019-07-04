package br.com.guedesdesouza.server.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSingleConectionSocket {

    public MyServerSingleConectionSocket(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        final Socket clientSocket = serverSocket.accept();
        final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String request;
        String response;
        while ((request = in.readLine()) != null) {
            if ("exit".equalsIgnoreCase(request)) {
                break;
            }
            response = processRequest(request);
            if (response != null) {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                    out.write(response);
                    out.flush();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    private String processRequest(String response) {
        if ("hello".equalsIgnoreCase(response)) {
            return "Hi Boy!\n";
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        new MyServerSingleConectionSocket(9000);
    }

}
