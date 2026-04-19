package D3AbstractFactoryPattern.Lecture.ConcreteImp;

import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public class MacOSScrollbar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("Scrolling in MacOS style.");
    }
    
}
