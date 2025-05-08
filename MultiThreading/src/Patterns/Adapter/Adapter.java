package Patterns.Adapter;

public class Adapter implements ClientAdapter{
    private Swimmer sw =null ;

    public Adapter(){
       sw = new Swimmer();
    }

    @Override
    public void fish() {
        sw.swim();
    }
}
