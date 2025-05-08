package Patterns.Composite;

public class Client {
    public static void main(String[] args){

        Folder f1 = new Folder();
        Folder f2 = new Folder();
        File file1 = new File();
        File file2 = new File();
        File file3 = new File();

        f1.add(file1);
        f1.add(file2);
        f2.add(file3);
        f1.add(f2);
        f1.open();
    }
}
