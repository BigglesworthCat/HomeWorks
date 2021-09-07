package Controller;

import java.util.Scanner;

import Model.*;
import View.*;
import static View.Constants.TextConstants.CHANGE_NICKNAME;

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
    public void processUser() throws FieldException {
        Scanner scanner = new Scanner(System.in);

        InputNoteBook inpN = new InputNoteBook(view, scanner);
        inpN.inputNote(); //Setting fields in note (field in model)

        model.addToNoteDB(inpN);

        boolean fieldIsUniq = false;

        while(!fieldIsUniq)
        {
            try {
                model.addToNoteDB(inpN);
                fieldIsUniq = true;
                System.out.println("КРАССАВА СТАСЯН!!!!!!");
            }
            catch (FieldException ex) {
                System.out.println(ex.message);
                UtilityController utilityController = new UtilityController(scanner, view);

                if (utilityController.chooseOption(CHANGE_NICKNAME))
                {
                    view.printInputMessage((String) "input.05.nickname");
                    inpN.fields_value[4] = utilityController.inputField("Nickname", View.regexBundle.getString("regexp.05.nickname"));
                }
                else
                {
                    inpN.fields_value[4] = "-";
                }
            }
        }
    }
}