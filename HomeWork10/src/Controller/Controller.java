package Controller;

import Model.Model;
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
        int[] array = Model.generateIntArray(10);

        View.printStructure(array);

        try {
            view.printMessage(View.MEAN_VALUE + Model.meanValue(array));
        }
        catch (EmptyArrayException ex) {
            view.printMessage(ex.getMessage());
        }

        view.printMessage(View.MIN_VALUE + Model.minValue(array));

        view.printMessage(View.EQUAL_TO_ZERO + Model.equalsToZero(array));

        view.printMessage(View.BIGGER_THAN_ZERO + Model.biggerThanZero(array));

        double number = 2.0;
        array = Model.multiplyInNumber(array, number);
        view.printMessage("After multiplying by " + number + ":");
        View.printStructure(array);
    }
}