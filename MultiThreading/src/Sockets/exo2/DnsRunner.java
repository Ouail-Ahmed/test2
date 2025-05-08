package Sockets.exo2;

import java.util.Scanner;

public class DnsRunner {
    public static void main (String[] args) {
        System.out.println("Please Enter the number of client you want ");
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int number = sc.nextInt();
            DnsServer dnsS = new DnsServer();
            new Thread(() -> {
                dnsS.startServer();
            }).start();

            for (int i = 0; i < number; i++) {
                final int clientId = i;
                new Thread(() -> {
                    DnsClient dnsc = new DnsClient();
                    dnsc.startClient(clientId);
                }).start();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        finally {
//            sc.close();
//        }
    }
}
