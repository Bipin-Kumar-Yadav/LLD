package D3AbstractFactoryPattern.Lecture.ConcreteFactoryImp;

import D3AbstractFactoryPattern.Lecture.ConcreteImp.MacOSButton;
import D3AbstractFactoryPattern.Lecture.ConcreteImp.MacOSScrollbar;
import D3AbstractFactoryPattern.Lecture.Factory.UIFactory;
import D3AbstractFactoryPattern.Lecture.Interfaces.Button;
import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public class MacFactoryImp implements UIFactory{
    @Override
    public Button createButton(){
        return new MacOSButton();
    }
    @Override
    public ScrollBar createScrollBar(){
        return new MacOSScrollbar();
    }
}
