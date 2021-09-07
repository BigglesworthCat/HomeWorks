package Controller;

import View.View;

public class FieldException extends Exception{
    String message;

    public FieldException(String mes, String field) { message = mes + " " + View.messagesBundle.getString(field); }
}
