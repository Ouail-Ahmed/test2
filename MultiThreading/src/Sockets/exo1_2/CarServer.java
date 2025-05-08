package Sockets.exo1_2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CarServer {
    private static int port = 5555;

    public static void main(String[] args){

        try(ServerSocket ss = new ServerSocket(port)){
            System.out.println("Server Listening on port: " + port);
            Car myCar = new Car("Bmw M5",2025, 2500);
            while(true){
                Socket sc = ss.accept();
                try(DataInputStream dis = new DataInputStream(sc.getInputStream())){
                   int i =  dis.readInt();
                   if(i ==1){
                       try(ObjectOutputStream dos = new ObjectOutputStream(sc.getOutputStream())){
                           dos.writeObject(myCar);
                           System.out.println("Car object sent ");
                       } catch (IOException e) {
                           System.err.println("Error :" + e.getMessage());
                       }
                   }else {
                       try(ObjectOutputStream dos = new ObjectOutputStream(sc.getOutputStream())){
                           dos.writeObject(new Car("Maclaren",2001,1500));
                           System.out.println("Car object sent ");
                       } catch (IOException e) {
                           System.err.println("Error :" + e.getMessage());
                       }
                   }

                } catch (RuntimeException e) {
                   System.err.println("Error: "+e.getMessage());

                }
            }
        }catch (IOException e){
            System.err.println("Error Starting the Server: "+ e.getMessage());
        }
    }
}
