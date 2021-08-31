public class View {
    public static final String BORDERS= "Do you want to set borders for picking number? (YES/NO) ";
    public static final String WRONG_BORDERS = "Please, enter your answer again (YES/NO): ";
    public static final String GENERETED_INFO = "Computer randomized number in interval [";
    public static final String INPUT_BORDERS= "Enter lower and upper borders: ";
    public static final String INPUT_INT= "Enter integer number to guess: ";
    public static final String NOT_INT = "Wrong type! Please, enter integer number: ";
    public static final String SMALLER_NUMBER = " is too small! Try on interval [";
    public static final String BIGGER_NUMBER = " is too big! Try on interval [";
    public static final String RESULT1 = "Congratulations! You guessed number! You used ";
    public static final String RESULT2 = " tries.\nAll your entered numbers: ";

    public void printMessage(String message)
    {
        System.out.print(message);
    }

    public void printWrongMessage(int userInt, String state, int lowerBorder, int upperBorder)
    {
        System.out.print(userInt + state + lowerBorder+"; "+upperBorder+"]: ");
    }
}