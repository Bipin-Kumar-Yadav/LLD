package D3AbstractFactoryPattern.ConcreteImp;

import D3AbstractFactoryPattern.Interfaces.Button;

public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in MacOS style.");
    }
    
}
