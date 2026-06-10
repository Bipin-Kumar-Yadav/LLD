package CompositePattern.Solution;



public class FileSystem {
    public static void main(String[] args) {
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        Folder folder1 = new Folder("Docs");
        Folder folder2 = new Folder("Finances");
        File file3 = new File("Fin1.txt");
        File file4 = new File("Fin2.txt");

        folder2.addComponent(file3);
        folder2.addComponent(file4);

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder1.addComponent(folder2);

        folder1.showDetails();
    }
}
