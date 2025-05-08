package Patterns.Composite;

public class File implements FolderComponent{


    @Override
    public void open() {
        System.out.println("opening a simple file ");
    }
}
