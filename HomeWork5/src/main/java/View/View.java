package View;

import java.util.Locale;
import java.util.ResourceBundle;

import static View.Constants.TextConstants.*;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.1
 */
public class View {
    static String MESSAGE_BUNDLE_NAME = "Messages";
    static String INPUT_FIELD_BUNDLE_NAME = "InputField";
    static String FIELDS_BUNDLE_NAME = "NoteFieldsNames";
    static String REGEX_BUNDLE_NAME = "Regex";
    static Locale currentLocale = new Locale("en");
    public static ResourceBundle messagesBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, currentLocale);
    public static ResourceBundle inputFieldBundle = ResourceBundle.getBundle(INPUT_FIELD_BUNDLE_NAME, currentLocale);
    public static ResourceBundle fieldsBundle = ResourceBundle.getBundle(FIELDS_BUNDLE_NAME, currentLocale);
    public static ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME, currentLocale);

    //Changes current locale in resource bundles
    public void changeLanguage(boolean res)
    {
        if(res)
        {
            switch (currentLocale.getLanguage()){
                case "en" -> currentLocale = new Locale.Builder().setLanguage("uk").build();
                case "uk" -> currentLocale = new Locale.Builder().setLanguage("en").build();
            }

            messagesBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, currentLocale);
            inputFieldBundle = ResourceBundle.getBundle(INPUT_FIELD_BUNDLE_NAME, currentLocale);
            fieldsBundle = ResourceBundle.getBundle(FIELDS_BUNDLE_NAME, currentLocale);
            regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME, currentLocale);
        }
    }

    /**
     *
     * @param message - array of strings
     * @return concat - result of concatenating
     */
    public String concatString(String... message)
    {
        StringBuilder concat = new StringBuilder();
        for(String i: message)
        {
            concat.append(i);
        }
        return new String(concat);
    }

    /**
     *
     * @param str - key from bundle with field's names
     * @return localized field's name
     */
    public static String fieldNameToString(String str)
    {
        return fieldsBundle.getString(str);
    }

    //Print localized message from message's bundle
    public void printBundleMessage(String message) { System.out.print(messagesBundle.getString(message) + " "); }

    public void printMessage(String message) { System.out.print(message); }

    //Prints localized "Enter field" message
    public void printInputMessage(String inputStr)
    {
        printMessage(concatString(messagesBundle.getString(ENTER) + " ", inputFieldBundle.getString(inputStr) + " "));
    }

    //Print localized "Wrong input" message
    public void printWrongMessage(String message)
    {
        printMessage(messagesBundle.getString(WRONG_INPUT) + " ");
    }
}