package Sockets.exo1_2;

import Sockets.exo1.Client;
import Sockets.exo1.Server;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class AppRunner {
    public static void main (String[] args){
        System.out.println("AppRunner: Starting Car Server...");
        Server server = new Server();

        new Thread(() -> {
            server.startServer();
        }).start();

        System.out.println("AppRunner: Server thread started. You can now start clients.");

        System.out.println("Enter the number of clients to start:");
        Scanner sc = new Scanner(System.in);

        try {
            int numberOfClients = sc.nextInt();

            if (numberOfClients <= 0) {
                System.out.println("AppRunner: No clients requested. Exiting.");
                return;
            }

            System.out.println("AppRunner: Starting " + numberOfClients + " Car Client(s)...");
            for (int i = 0; i < numberOfClients; i++) {
                // Run each client in a separate thread to allow multiple simultaneous connections
                final int clientId = i + 1;
                new Thread(() -> {
                    Client client = new Client();
                    client.startClient(clientId); // Call the client's start method
                }).start();

            }
        } catch (java.util.InputMismatchException e) {
            System.err.println("AppRunner: Invalid input. Please enter a number.");
        }
//        finally {
//        :w
//              sc.close();
//        }
    }
}