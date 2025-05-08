package Sockets.exo1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    private static final String address = "localhost";
    private static final int port = 5555;
    public static void main(String[] args) throws IOException {
        System.out.println("starting Client on Stand-alone");
        new Client().startClient(1 );
    }
    public void startClient(int clientId){

        try(Socket s = new Socket(address ,port)) {
            System.out.println("Client "+ clientId+ " Connected To "+ s.getInetAddress());

            try(ObjectInputStream ois = new ObjectInputStream(s.getInputStream())) {
                while (true) {
                    try{
                        Car ourCar = (Car) ois.readObject();
                        System.out.println("Client "+ clientId+ " Received Car object:\n" + ourCar);

                    }catch(EOFException e ){
                        System.out.println("Client "+ clientId+ " End of Stream reached ");
                        break;
                    }catch(ClassNotFoundException e){
                        System.err.println("Client "+ clientId+ " Received Object is not a Car");
                    } catch(IOException e){
                        System.err.println("Error Receiving Object from Server: " + e.getMessage());
                    }
                }


            }catch(IOException e){

                System.err.println("Error Connecting to server: " + e.getMessage());
            }
        }catch (IOException e){

            System.err.println("Error Connecting to server: " + e.getMessage());
        }
    }

}

