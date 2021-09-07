package Controller;

import View.*;

import java.util.Arrays;
import java.util.Scanner;

import static View.Constants.TextConstants.*;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.2
 */
public class InputNoteBook {
    private final View view;
    private final Scanner scanner;

    public String[] fields_key = { //Array of Note fields keys
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

    public String[] fields_value = new String[fields_key.length]; //Array of NoteBook fields values

    public InputNoteBook(View view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public void inputNote() {
        Arrays.fill(fields_value, "-"); //Fill all fields with "-"

        UtilityController utilityController = new UtilityController(scanner, view);

        view.changeLanguage(utilityController.chooseOption(CHANGE_LANGUAGE)); //Process of choosing language

        String str;
        var inputFields = View.inputFieldBundle.keySet().toArray(); //Creating arrays of input messages and regexes
        var regex = View.regexBundle.keySet().toArray();

        Arrays.sort(inputFields);
        Arrays.sort(regex);

        for (int i = 0; i < 19; i++) {
            String reg = View.regexBundle.getString((String) regex[i]); //Get current localized regex

            if (!(fields_key[i]).equals("Surname N.") && !(fields_key[i]).equals("Address")) {
                view.printInputMessage((String) inputFields[i]);

                fields_value[i] = utilityController.inputField(fields_key[i], reg);
            }
        }
        setOtherFields(); //Setting "Surname N." and "Address" fields
    }

    //Saving some fields for setting other fields (Surname N., Address) later
    void setOtherFields() {
        String name = "-", surname = "-", index = "-", city = "-", street = "-", house = "-", flat = "-";
        for (int i = 0; i < fields_value.length; i++) {
            //Saving some fields for setting other fields (Surname N., Address) later
            switch (fields_key[i]) {
                case "Surname" -> surname = fields_value[i];
                case "Name" -> name = fields_value[i];
                case "Surname N." -> fields_value[i] = (surname + " " + name.charAt(0) + ".");
                case "Index" -> index = fields_value[i];
                case "City" -> city = fields_value[i];
                case "Street" -> street = fields_value[i];
                case "House" -> house = fields_value[i];
                case "Flat" -> flat = fields_value[i];
                case "Address" -> fields_value[i] = (index + ", " + city + ", " + street + "str., " + house + ", " + flat);
            }
        }
    }
}

