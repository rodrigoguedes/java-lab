package br.com.guedesdesouza.server.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServerConectionBlokingSocket {

    public List<Socket> clients = new ArrayList<>();

    public MyServerConectionBlokingSocket(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try {
                final Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println(amountConnectedClient());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            String request;
                            String response;
                            while ((request = in.readLine()) != null) {
                                //System.out.println(clientSocket.getRemoteSocketAddress());
                                if ("exit".equalsIgnoreCase(request)) {

                                    try {
                                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                                        out.write("bye!\n");
                                        out.flush();
                                    } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                    }

                                    clientSocket.close();
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
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public long amountConnectedClient() {
        return clients.stream().filter(Socket::isConnected).count();
    }

    private String processRequest(String response) {
        if ("hello".equalsIgnoreCase(response)) {
            return "Hi Boy!\n";
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        new MyServerConectionBlokingSocket(9000);
    }

}
