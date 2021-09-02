package Controller;

import Model.*;
import View.*;

import java.util.Scanner;
import java.util.regex.*;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser()
    {
        Scanner sc = new Scanner(System.in);

//        view.printMessage(View.CHANGE_LANGUAGE);
//        chooseLanguage(sc); //Asking user if he wants to change language

        setNoteFields(sc);
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
            view.printWrongMessage(View.WRONG_INPUT);
        }
    }

    void setNoteFields(Scanner sc)
    {
        String field;

        view.printInputMessage(View.SURNAME, View.REGEX_SURNAME);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_SURNAME));
        model.note.putField(View.inputBundle.getString(View.SURNAME), field);

        view.printInputMessage(View.NAME, View.REGEX_NAME);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_NAME));
        model.note.putField(View.inputBundle.getString(View.NAME), field);

        view.printInputMessage(View.PATRONYMIC, View.REGEX_PATRONYMIC);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_PATRONYMIC));
        model.note.putField(View.inputBundle.getString(View.PATRONYMIC), field);

        view.printInputMessage(View.NICKNAME, View.REGEX_NICKNAME);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_NICKNAME));
        model.note.putField(View.inputBundle.getString(View.NICKNAME), field);

        view.printInputMessage(View.COMMENT, View.REGEX_COMMENT);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_COMMENT));
        model.note.putField(View.inputBundle.getString(View.COMMENT), field);

        view.printInputMessage(View.GROUP, View.REGEX_GROUP);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_GROUP));
        model.note.putField(View.inputBundle.getString(View.GROUP), field);

        view.printInputMessage(View.HOME_NUMBER, View.REGEX_HOME_NUMBER);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_HOME_NUMBER));
        model.note.putField(View.inputBundle.getString(View.HOME_NUMBER), field);

        view.printInputMessage(View.MOBILE_PHONE_1, View.REGEX_MOBILE_PHONE_1);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_MOBILE_PHONE_1));
        model.note.putField(View.inputBundle.getString(View.MOBILE_PHONE_1), field);

        view.printInputMessage(View.REGEX_MOBILE_PHONE_2, View.REGEX_MOBILE_PHONE_2);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_MOBILE_PHONE_2));
        model.note.putField(View.inputBundle.getString(View.REGEX_MOBILE_PHONE_2), field);

        view.printInputMessage(View.EMAIL, View.REGEX_EMAIL);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_EMAIL));
        model.note.putField(View.inputBundle.getString(View.EMAIL), field);

        view.printInputMessage(View.SKYPE, View.REGEX_SKYPE);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_SKYPE));
        model.note.putField(View.inputBundle.getString(View.SKYPE), field);

        view.printInputMessage(View.ADDRESS, View.REGEX_ADDRESS);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_ADDRESS));
        model.note.putField(View.inputBundle.getString(View.ADDRESS), field);

        view.printInputMessage(View.INPUT_DATE, View.REGEX_INPUT_DATE);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_INPUT_DATE));
        model.note.putField(View.inputBundle.getString(View.INPUT_DATE), field);

        view.printInputMessage(View.LAST_CHANGE_DATE, View.REGEX_LAST_CHANGE_DATE);
        field = inputField(sc, View.regexBundle.getString(View.REGEX_LAST_CHANGE_DATE));
        model.note.putField(View.inputBundle.getString(View.LAST_CHANGE_DATE), field);
    }

    String inputField(Scanner sc, String regex)
    {
        String str = sc.next();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher  = pattern.matcher(str);
        while(!matcher.matches())
        {
            view.printWrongMessage(View.WRONG_INPUT);
            str = sc.next();
            matcher = pattern.matcher(str);
        }
        return str;
    }
}