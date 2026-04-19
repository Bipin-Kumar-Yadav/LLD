package D3AbstractFactoryPattern.Lecture.ConcreteFactoryImp;

import D3AbstractFactoryPattern.Lecture.ConcreteImp.WindowButton;
import D3AbstractFactoryPattern.Lecture.ConcreteImp.WindowScrollbar;
import D3AbstractFactoryPattern.Lecture.Factory.UIFactory;
import D3AbstractFactoryPattern.Lecture.Interfaces.Button;
import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public class WindowsFactoryImp implements UIFactory{
    @Override
    public Button createButton(){
        return new WindowButton();
    }

    @Override 
    public ScrollBar createScrollBar(){
        return new WindowScrollbar();
    }
}
