package com.gawdski.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("192.168.1.5", 7778);
            Scanner scanner = new Scanner(System.in);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Player configuration completed");

            System.out.println(reader.readLine());
            String name = scanner.nextLine();
            writer.println(name);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
