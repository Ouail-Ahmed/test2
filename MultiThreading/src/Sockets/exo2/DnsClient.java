package Sockets.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DnsClient {
    private static final int port = 5555;
    private static final String theAddress ="localhost";

    public static void main(String[] args){
        new DnsClient().startClient(1);
    }
    public void startClient(int id){
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter you address:");
        String address = sc.nextLine();
        try( Socket s = new Socket(theAddress, port)){
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(address);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            String ip = (String) ois.readObject();
            System.out.println("The Ip address you are looking for is: "+ip);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
