package Controller;

import View.View;

public class TriangleException extends Exception{
    private String message;
    public TriangleException() {
        this.message = "Triangle doesn't exists! Triangle conditions isn't followed.\n";
    }
}