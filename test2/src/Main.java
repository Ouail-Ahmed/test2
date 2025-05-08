
public class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[50];
        int finalSum =0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= i;
            System.out.println("tab["+i+"]: "+ i);
        }
        Counter[] counterTab = {new Counter(0, numbers),new Counter(5, numbers)};

        System.out.println("Starting counter thread...");
        for (Counter s : counterTab){
            s.start();
        }
        for (Counter s : counterTab){
            s.join();
            finalSum = finalSum + s.sum;
        }

        System.out.println("the final sum is: "+ finalSum);
    }
}
