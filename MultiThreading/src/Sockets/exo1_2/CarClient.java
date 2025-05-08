package Sockets.exo1_2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class CarClient {
    private static final String address = "localhost";
    private static final int port = 5555;

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        try(Socket s = new Socket(address , port)){
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            System.out.println("Enter the Id of the Car you want");
            int id = sc.nextInt();
            dos.writeInt(id);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Car ourCar = (Car) ois.readObject();
            System.out.println("Car received: " + ourCar);
        }catch(IOException | ClassNotFoundException e ){
            System.err.println("Error: "+e.getMessage());
        }
    }
}
