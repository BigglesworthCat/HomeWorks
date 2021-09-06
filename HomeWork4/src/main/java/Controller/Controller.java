package Controller;

import java.util.Scanner;

import Model.*;
import View.*;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.3
 */

public class Controller {
    private final Model model;
    private final View view;

    /**
     *
     * @param model - Model object
     * @param view - View object
     */
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser()
    {
        Scanner sc = new Scanner(System.in);

        InputNoteBook inpN = new InputNoteBook(view, sc, model);

        inpN.inputNote(); //Setting fields in note (field in model)
    }
}