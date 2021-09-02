package View;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements TextConstants, RegexConstants{
    static String MESSAGE_BUNDLE_NAME = "Messages";
    static String REGEX_BUNDLE_NAME = "Regex";
    static Locale currentLocale = new Locale("en");
    public static ResourceBundle inputBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, currentLocale);
    public static ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME, currentLocale);

    public void changeLanguage()
    {
        switch (currentLocale.getLanguage()){
            case "en" -> currentLocale = new Locale.Builder().setLanguage("uk").build();
            case "uk" -> currentLocale = new Locale.Builder().setLanguage("en").build();
        }

        inputBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, currentLocale);
        regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME, currentLocale);
    }

    public String concatString(String... message)
    {
        StringBuilder concat = new StringBuilder();
        for(String i: message)
        {
            concat = concat.append(i);
        }
        return new String(concat);
    }

    //public void printMessage(String message) { System.out.print(inputBundle.getString(message)); }

    public void printMessage(String message) { System.out.print(message); }

    public void printInputMessage(String inputStr, String regexStr)
    {
        printMessage(concatString(inputBundle.getString(ENTER) + " ", inputBundle.getString(inputStr) + " ", regexBundle.getString(regexStr) + ": "));
    }

    public void printWrongMessage(String message)
    {
        printMessage(inputBundle.getString(WRONG_INPUT) + " ");
    }
}