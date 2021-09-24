package Controller;

public class EmptyArrayException extends Exception{
    private String message;

    public EmptyArrayException() {
        this.message = "Your array is empty!\n";
    }
}