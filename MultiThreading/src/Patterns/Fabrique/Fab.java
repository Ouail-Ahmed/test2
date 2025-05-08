package Patterns.Fabrique;

public class Fab extends AbsFab{


    @Override
    public P makeStuff(String s) {
        if(s.equals("p1")){
            return new P1();
        }else if (s.equals("p2")){
            return new P2();
        }
        return null;
    }
}
