package DocumentEditorLLD;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    public abstract String render();
}

class TextElement implements DocumentElement{
    private String text;
    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String imagePath;
    public ImageElement(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public String render(){
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement{
    @Override 
    public String render(){
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement{
    @Override
    public String render(){
        return "\t";
    }
}

interface Persistence{
    public abstract void save(String content);
} 

class FilePersistence implements Persistence{
    @Override
    public void save(String data){
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (Exception e) {
            System.out.println("Error saving document: "+ e.getMessage());
        }
    }
}

class DbPersistence implements Persistence{
    @Override
    public void save(String data){
        System.out.println("Document saved to database: " + data);
    }
}

class Document{
    private List<DocumentElement> elements = new ArrayList<>();
    
    public void addElement(DocumentElement element){
        elements.add(element);
    }

    public List<DocumentElement> getElement(){
        return elements;
    }
}

class DocumentRender{
    private Document document;

    public DocumentRender(Document document){
        this.document = document;
    }

    public String render(){
        String result = "";
        for(DocumentElement element: document.getElement()){
            result +=element.render();
        }
        return result;
    } 
    
}

class DocumentEditor{
    private final Document document;

    public DocumentEditor(Document document){
        this.document = document;
    }

    public void addElement(DocumentElement element){
        document.addElement(element);
    }

    public String renderDoc(){
       DocumentRender render = new DocumentRender(document);
       return render.render();
    }
}

public class DocumentEditorLLD {
    public static void main(String[] args) {
        Document doc = new Document();
        Persistence filePersistence = new FilePersistence();
        DocumentEditor editor = new DocumentEditor(doc);

        editor.addElement(new TextElement("Hello, this is a sample document."));
        editor.addElement(new NewLineElement());
        editor.addElement(new TabSpaceElement());
        editor.addElement(new ImageElement("path/to/image.png"));
        editor.addElement(new NewLineElement());
        
        String file = editor.renderDoc();

        filePersistence.save(file);
    }
}
