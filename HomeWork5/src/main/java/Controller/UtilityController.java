package Controller;

import Model.Groups;
import View.*;
import static View.Constants.TextConstants.WRONG_INPUT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.1
 */

public class UtilityController {
    private final Scanner scanner;
    private final View view;

    public UtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public boolean chooseOption(String input) {
        view.printBundleMessage(input); //Asking user if he wants to change "input"
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

    //Input field with matching it with appropriate regex
    String inputField(String field, String regex)
    {
        String str;
        if(field.equals("Street"))
        {
            str = scanner.nextLine(); //Street can include few words
        }
        else{
            str = scanner.next();
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher  = pattern.matcher(str);

        switch (field)
        {
            case "Group":
                while(!Groups.contains(str))
                {
                    view.printWrongMessage(WRONG_INPUT);
                    str = scanner.nextLine();
                }
                break;
            case "Input date":
            case "Date of last info changes":
                while(!matcher.matches() | !isDateValid(str))
                {
                    view.printWrongMessage(WRONG_INPUT);
                    str = scanner.nextLine();
                }
                break;
            default:
                while(!matcher.matches())
                {
                    view.printWrongMessage(WRONG_INPUT);
                    if(field.equals("Street"))
                    {
                        str = scanner.nextLine(); //Street can include few words
                    }
                    else{
                        str = scanner.next();
                    }
                    matcher = pattern.matcher(str);
                }
                break;
        }
        return str;
    }

    //Check if date in parameter is valid using DateFormat class
    boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }
}