package Controller;

import Model.*;
import View.*;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser() {
        model.testClasses();
    }
}