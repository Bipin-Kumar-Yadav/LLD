package D3AbstractFactoryPattern.Lecture.Factory;

import D3AbstractFactoryPattern.Lecture.Interfaces.Button;
import D3AbstractFactoryPattern.Lecture.Interfaces.ScrollBar;

public interface UIFactory {
    Button createButton();
    ScrollBar createScrollBar();
}
