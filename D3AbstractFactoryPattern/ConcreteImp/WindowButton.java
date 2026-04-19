package D3AbstractFactoryPattern.ConcreteImp;

import D3AbstractFactoryPattern.Interfaces.Button;

public class WindowButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style button.");
    }
    
}
