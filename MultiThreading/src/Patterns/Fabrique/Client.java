package Patterns.Fabrique;

public class Client {
    public static void main(String[] args){
        Fab f = new Fab();

        P[] p ={f.makeStuff("p1"),f.makeStuff("p2")};
        for (P i : p){
            i.run();
        }
    }
}
