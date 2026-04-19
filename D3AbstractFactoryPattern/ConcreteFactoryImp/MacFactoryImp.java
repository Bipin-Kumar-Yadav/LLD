package D3AbstractFactoryPattern.ConcreteFactoryImp;

import D3AbstractFactoryPattern.ConcreteImp.MacOSButton;
import D3AbstractFactoryPattern.ConcreteImp.MacOSScrollbar;
import D3AbstractFactoryPattern.Factory.UIFactory;
import D3AbstractFactoryPattern.Interfaces.Button;
import D3AbstractFactoryPattern.Interfaces.ScrollBar;

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
