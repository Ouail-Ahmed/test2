public class Counter extends Thread{
    int start;  int[] tab;
    int sum = 0;

    public Counter( int start , int[] tab){
        this.start = start;
        this.tab = tab;
    }

    @Override
    public void run() {
        for (int i = start; i < start+5; i++) {
            sum = sum + tab[i];
        }
    }
}
