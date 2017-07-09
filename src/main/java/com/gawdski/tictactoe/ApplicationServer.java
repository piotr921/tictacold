package com.gawdski.tictactoe;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApplicationServer {

    private static final int PORT = 7778;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket player1Socket = serverSocket.accept();
                Socket player2Socket = serverSocket.accept();

                BufferedReader player1Reader = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
                BufferedReader player2Reader = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));

                PrintWriter player1Writer = new PrintWriter(player1Socket.getOutputStream());
                PrintWriter player2Writer = new PrintWriter(player2Socket.getOutputStream());

                MatchEngine matchEngine = new MatchEngine();
                matchEngine.initializeMatch();
                matchEngine.playMatch();
            }
        } catch (QuitGameException e) {
            System.out.println("Match ended by pressing 'q' button / Mecz zakończony przez wciśnięcie klawisza 'q'");
        } catch (IOException e) {
            System.out.println("Cannot connect to port: " + PORT + " / Nie można połączyć się z portem: " + PORT);
        }
    }
}
