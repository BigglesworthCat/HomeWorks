package Controller;

import View.*;

import java.util.Scanner;

import static View.Constants.TextConstants.CHANGE_LANGUAGE;
import static View.Constants.TextConstants.WRONG_INPUT;

public class UtilityController {
    private final Scanner scanner;
    private final View view;

    public UtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public boolean chooseLanguage()
    {
        view.printBundleMessage(CHANGE_LANGUAGE); //Asking user if he wants to change language
        String res;
        while (true)
        {
            res = scanner.next();
            if (res.equalsIgnoreCase("YES"))
            {
                return true;
            }
            else if(res.equalsIgnoreCase("NO"))
            {
                return false;
            }
            view.printWrongMessage(WRONG_INPUT);
        }
    }

}