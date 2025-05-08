package Patterns.Composite;

import java.util.ArrayList;

public class Folder implements FolderComponent{

    ArrayList<FolderComponent> fileList = new ArrayList<>();


    public void open(){
        System.out.println("opening the Folder ");
    }
    public void add(FolderComponent f){
//        fileList.add(f);
        for(FolderComponent x : fileList){
            x.open();
        }

    }
}
