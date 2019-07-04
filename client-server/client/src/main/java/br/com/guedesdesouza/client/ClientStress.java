package br.com.guedesdesouza.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientStress {

    private static int countErros = 0;

    public ClientStress() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        socket.setKeepAlive(true);
        BufferedReader reader_server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writerServer = new PrintWriter(socket.getOutputStream(),true);

        writerServer.println("hello");

//        String response = reader_server.readLine();
//        System.out.println(response);
//
//        writerServer.println("exit");
//        response = reader_server.readLine();
//        System.out.println(response);

        String response = reader_server.readLine();
        while ((response = reader_server.readLine()) != null) {
            System.out.println(response);
//            if ("bye!".equalsIgnoreCase(response)) {
//                System.exit(0);
//            }
        }
    }

    public static void main(String[] args) throws IOException {

        for (int i=0; i<= 10000; i++) {
            //System.out.println(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new ClientStress();
                    } catch (IOException e) {
                        countErros++;
                        System.out.println(countErros);
                        //e.printStackTrace();
                    }
                }
            }).start();
        }
        //while(true) { }

    }

}
