package D3AbstractFactoryPattern.Lecture.ConcreteImp;

import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public class WindowScrollbar implements ScrollBar{
    @Override
    public void scroll(){
        System.out.println("Window ScrollBar scrolled");
    }
}
