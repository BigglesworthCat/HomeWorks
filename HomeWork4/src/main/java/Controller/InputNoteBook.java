package Controller;

import Model.*;
import View.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.Constants.TextConstants.WRONG_INPUT;

public class InputNoteBook {
    private final View view;
    private final Scanner scanner;
    private final Model model;

    public InputNoteBook(View view, Scanner scanner, Model model) {
        this.view = view;
        this.scanner = scanner;
        this.model = model;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(scanner, view);

        //view.printBundleMessage(CHANGE_LANGUAGE); //Asking user if he wants to change language
        view.changeLanguage(utilityController.chooseLanguage()); //Process of choosing language

        String str = "-", name = "-", surname = "-", index = "-", city = "-", street = "-", house = "-", flat = "-";
        var inputFields = View.inputFieldBundle.keySet().toArray();
        var regex = View.regexBundle.keySet().toArray();

        String[] fields = {
                "Surname",
                "Name",
                "Patronymic",
                "Surname N.",
                "Nickname",
                "Comment",
                //"Group",
                "HomeNumber",
                "MobileNumber1",
                "MobileNumber2",
                "Email",
                "Skype",
                "Index",
                "City",
                "Street",
                "House",
                "Flat",
                "Address",
                "Input date",
                "Date of last info changes"};

        Arrays.sort(inputFields);
        Arrays.sort(regex);

        for (int i = 0; i < 19; i++) {
            String reg = View.regexBundle.getString((String) regex[i]);

            if (!(fields[i]).equals("Surname N.") && !(fields[i]).equals("Address")) {
                view.printInputMessage((String) inputFields[i]);

                str = inputField(fields[i], reg);
                model.note.putField(fields[i], str);
            }

            //Saving some fields for setting other(Surname N., Address) later
            switch (fields[i]) {
                case "Surname" -> surname = str;
                case "Name" -> name = str;
                case "Surname N." -> model.note.putField(fields[i], surname + " " + name.charAt(0) + ".");
                case "Index" -> index = str;
                case "City" -> city = str;
                case "Street" -> street = str;
                case "House" -> house = str;
                case "Flat" -> flat = str;
                case "Address" -> model.note.putField(fields[i], index + ", " + city + ", " + street + "str., " + house + ", " + flat);
            }
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
        } catch (ParseException e)
        {
            return false;
        }
    }

}
