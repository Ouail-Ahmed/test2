package Sockets.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class DnsServer {

    private static final int port = 5555;
    private Dns[] dnsList = {new Dns("www.google.com","192.168.3.2"),
            new Dns("www.bing.com","192.168.3.99"),
            new Dns("www.duckduckgo.com","192.168.4.2")};
    public static void main(String[] args){
        System.out.println("Starting Dns on Stand Alone");
        new DnsServer().startServer();
    }

    public void startServer(){
        try {
            ServerSocket ss = new ServerSocket(port);
            while(true){
                Socket s =ss.accept();
                try(ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
                   String address =(String) ois.readObject();
                    System.out.println("Client sent: " + address);
                    try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
                       for (Dns d : dnsList){
                           if(Objects.equals(d.getDnsAde(), address)){
                                  oos.writeObject(d.getDnsStr());
//                                  System.out.println("Object found");
                               return;
                           }else{
                               oos.writeObject("NOT_FOUND");
//                               System.out.println("Server: Address not found." );
                           }
                       }
                       oos.flush();
                    }

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new IOException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
