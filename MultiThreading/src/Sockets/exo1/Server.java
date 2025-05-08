package Sockets.exo1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 5555;

    public static void main(String[] args){
        System.out.println("Starting Server in Stand alone mode");
        new Server().startServer();

    }
    public void startServer(){

        Car[] carList ={new Car("Bmw M5",2020 , 2000),
                new Car("Audi A6" , 2021, 2100),
                new Car( "Mercedis E-Class",2019, 1900)};
        try( ServerSocket ss = new ServerSocket(port)){
            System.out.println("Server listening on port: "+ port);
            while( true){
                Socket cs = ss.accept();
                System.out.println("clinet connected: "+ cs.getInetAddress());


                try(ObjectOutputStream oop = new ObjectOutputStream(cs.getOutputStream())){
                    for (Car c: carList){

                        oop.writeObject(c);
                        System.out.println("sent object:" + c);
                    }

                }catch(IOException e){
                    System.err.println("Error Sending Car: " + e.getMessage());
                }finally {
                    try{
                        cs.close();
                        System.out.println("Client closing connection ");
                    }catch (IOException e){
                        System.err.println("Error closing connection: "+ e.getMessage());
                    }
                }
            }
        }catch (IOException e){
            System.err.println("Error Starting the server: " + e.getMessage());
        }
    }
}
