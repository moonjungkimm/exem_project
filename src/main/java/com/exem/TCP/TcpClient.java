package com.exem.TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class TcpClient {

   public static void main(String[] args) {
      String serverAddress = "127.0.0.1";
      int port = 5000;

      try (Socket socket = new Socket(serverAddress, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
         String fromServer;
         while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
         }
      } catch (IOException e) {
         System.out.println("Exception caught when trying to connect to " + serverAddress + ":" + port);
         System.out.println(e.getMessage());
      }
   }
}