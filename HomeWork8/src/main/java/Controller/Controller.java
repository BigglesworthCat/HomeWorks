package Controller;

import Model.Model;
import Model.Part1.*;
import View.View;

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
        view.printMessage("--===Part 1 (Triangle)===--\n");

        try{
            Shape shape = new Triangle(new Point(0,0),new Point(3,0), new Point(0, 4));
            System.out.println(shape);
        }
        catch(TriangleException exception)
        {
            view.printMessage(exception.getMessage());
        }
    }
}
