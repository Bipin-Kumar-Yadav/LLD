package D3AbstractFactoryPattern.ConcreteImp;

import D3AbstractFactoryPattern.Interfaces.ScrollBar;

public class WindowScrollbar implements ScrollBar{
    @Override
    public void scroll(){
        System.out.println("Window ScrollBar scrolled");
    }
}
