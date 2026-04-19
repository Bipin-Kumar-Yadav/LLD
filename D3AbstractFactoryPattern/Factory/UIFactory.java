package D3AbstractFactoryPattern.Factory;

import D3AbstractFactoryPattern.Interfaces.Button;
import D3AbstractFactoryPattern.Interfaces.ScrollBar;

public interface UIFactory {
    Button createButton();
    ScrollBar createScrollBar();
}
