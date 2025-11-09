package CompositePattern;

import java.util.ArrayList;
import java.util.List;

// Base interface for files and folders
interface FileSystemItem{
    void ls(int indent);
    void openAll(int indent);
    int getSize();
    FileSystemItem cd(String name);
    String getName();
    boolean isFolder();
}

//Leaf file
class File implements FileSystemItem{
    private String name;
    private int size;

    public File(String name, int size){
        this.name  = name;
        this.size = size;
    }

    @Override
    public void ls(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + name);
    }

    @Override 
    public void openAll(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + "Opening file: " + name);
    }

    @Override 
    public int getSize(){
        return size;
    }

    @Override
    public FileSystemItem cd(String name){
        return null;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override 
    public boolean isFolder(){
        return false;
    }
}
// intermediate node

class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> items;

    public Folder(String name){
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(FileSystemItem item){
        items.add(item);
    }

    @Override 
    public void ls(int indent){
        String indentSpace = " ".repeat(indent);
        for(FileSystemItem item : items){
            if(item.isFolder()){
                System.out.println(indentSpace + " + " + item.getName() );
            }
            else{
                System.out.println(indentSpace + " - " + item.getName() );
            }
        }
    }

    @Override
    public void openAll(int indent){
        String indentSpace = " ".repeat(indent);
        System.out.println(indentSpace + "Opening folder: " + name);
        for(FileSystemItem item : items){
            item.openAll(indent + 2);
        }
    }


    @Override 
    public int getSize(){
        int total = 0;
        for(FileSystemItem item : items){
            total += item.getSize();
        }
        return total;
    }

    @Override 
    public FileSystemItem cd(String name){
        for(FileSystemItem item : items){
            if(item.isFolder() && item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    @Override 
    public String getName(){
        return name;
    }   

    @Override
    public boolean isFolder(){
        return true;
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.addItem(new File("file1.txt", 100));
        root.addItem(new File("file2.txt", 200));

        Folder docs = new Folder("docs");
        docs.addItem(new File("resume.txt",200));
        docs.addItem(new File("notes.txt",300));
        root.addItem(docs);

        Folder images = new Folder("images");
        images.addItem(new File("photo1.jpg",500));
        images.addItem(new File("photo2.png",700));
        root.addItem(images);

        Folder music = new Folder("music");
        music.addItem(new File("song1.mp3",4000));
        music.addItem(new File("song2.wav",6000));
        images.addItem(music);
        // root.ls(0);
        // root.openAll(0);
        FileSystemItem cwd = root.cd("music");
        if(cwd != null){
            cwd.ls(3);
        }
        else{
            System.out.println("Folder not found");
        }
    }
}
