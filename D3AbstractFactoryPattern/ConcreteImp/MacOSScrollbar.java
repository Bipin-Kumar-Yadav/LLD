package D3AbstractFactoryPattern.ConcreteImp;

import D3AbstractFactoryPattern.Interfaces.ScrollBar;

public class MacOSScrollbar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("Scrolling in MacOS style.");
    }
    
}
