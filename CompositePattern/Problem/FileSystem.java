package CompositePattern.Problem;

public class FileSystem {
    public static void main(String[] args) {
        
        File f1 = new File("file1.txt");
        File f2 = new File("File2.txt");

        Folder folder = new Folder("Docs");
        folder.addFiles(f1);
        folder.addFiles(f2);

        folder.showDetails();
    }
}
