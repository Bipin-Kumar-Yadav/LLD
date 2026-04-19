package D3AbstractFactoryPattern.ConcreteFactoryImp;

import D3AbstractFactoryPattern.ConcreteImp.WindowButton;
import D3AbstractFactoryPattern.ConcreteImp.WindowScrollbar;
import D3AbstractFactoryPattern.Factory.UIFactory;
import D3AbstractFactoryPattern.Interfaces.Button;
import D3AbstractFactoryPattern.Interfaces.ScrollBar;

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
