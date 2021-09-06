package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

import Model.*;
import View.*;
import static View.Constants.TextConstants.*;


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

        view.printBundleMessage(CHANGE_LANGUAGE); //Asking user if he wants to change language
        chooseLanguage(sc); //Process of choosing language

        setNoteFields(sc); //Setting fields in NoteBook object
    }

    void chooseLanguage(Scanner sc)
    {
        String res;
        while (true)
        {
            res = sc.next();
            if (res.equalsIgnoreCase("YES"))
            {
                view.changeLanguage();
                break;
            }
            else if(res.equalsIgnoreCase("NO"))
            {
                break;
            }
            view.printWrongMessage(WRONG_INPUT);
        }
    }

    void setNoteFields(Scanner sc)
    {
        String str = "-", name = "-", surname = "-", index = "-", city = "-", street = "-", house = "-", flat = "-";
        var inputFields = View.inputFieldBundle.keySet().toArray();
        var fields = View.fieldsBundle.keySet().toArray();
        var regex = View.regexBundle.keySet().toArray();

        Arrays.sort(inputFields);
        Arrays.sort(fields);
        Arrays.sort(regex);

        for(int i = 0; i <= 20; i++)
        {
            String reg = View.regexBundle.getString((String)regex[i]);
            String fil = View.fieldsBundle.getString((String)fields[i]);

            if(!((String) fields[i]).equals("field.04.surname_n") && !((String) fields[i]).equals("field.18.address"))
            {
                view.printInputMessage((String) inputFields[i]);

                str = inputField(sc, (String) fields[i], reg);
                model.note.putField(fil, str);
            }

            switch ((String) fields[i])
            {
                case "field.01.surname" ->  surname = str;
                case "field.02.name" ->  name = str;
                case "field.04.surname_n" -> model.note.putField(fil, surname + " " + name.charAt(0) + ".");
                case "field.13.index" ->  index = str;
                case "field.14.city" ->  city = str;
                case "field.15.street" ->  street = str;
                case "field.16.house" ->  house = str;
                case "field.17.flat" ->  flat = str;
                case "field.18.address" ->  model.note.putField(fil, index + ", " + city + ", " + street + "str., " + house + ", " + flat);
            }

        }
    }

    //Input field with matching it with appropriate regex
    String inputField(Scanner sc, String field, String regex)
    {
        String str = sc.next();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher  = pattern.matcher(str);

        switch (field)
        {
            case "input.group.data":
                while(!Groups.contains(str))
                {
                    view.printWrongMessage(WRONG_INPUT);
                    str = sc.nextLine();
                }
                break;
            case "input.lastChangeDate.data":
            case "input.inputDate.data":
                while(!matcher.matches() | !isDateValid(str))
                {
                    view.printWrongMessage(WRONG_INPUT);
                    str = sc.nextLine();
                }
                break;
            default:
                while(!matcher.matches())
                {
                    view.printWrongMessage(WRONG_INPUT);
                    str = sc.next();
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