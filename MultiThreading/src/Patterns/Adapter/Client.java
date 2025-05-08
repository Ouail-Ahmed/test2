package Patterns.Adapter;

public class Client {

    public static void main(String[] args){
        ClientAdapter ad = new Adapter();

        ad.fish();

    }
}
