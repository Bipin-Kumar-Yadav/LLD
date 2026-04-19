package D3AbstractFactoryPattern.Lecture;

import D3AbstractFactoryPattern.Lecture.ConcreteFactoryImp.WindowsFactoryImp;
import D3AbstractFactoryPattern.Lecture.Factory.UIFactory;
import D3AbstractFactoryPattern.Lecture.Interfaces.Button;
import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public class Application {
    private Button button;
    private ScrollBar scrollBar;

    public Application(UIFactory factory){
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI(){
        button.render();
        scrollBar.scroll();
    }
    public static void main(String[] args) {
        Application app = new Application(new WindowsFactoryImp());
        app.renderUI();
    }
}
