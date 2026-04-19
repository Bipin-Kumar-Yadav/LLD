package D3AbstractFactoryPattern.Lecture.ConcreteImp;

import D3AbstractFactoryPattern.Lecture.Interfaces.Button;

public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in MacOS style.");
    }
    
}
