public class View {
    public static final String INPUT_HELLO_WORLD = "Enter \"Hello world\": ";
    public static final String WRONG_WORD1 = "Wrong word! Please, enter \"Hello\": ";
    public static final String WRONG_WORD2 = "Wrong word! Please, enter \"world!\": ";
    public static final String OUR_INPUT = "Your result input: ";

    public void printMessage(String message){

        System.out.print(message);
    }

    public void printMessageAndString(String message, String value1, String value2){
        System.out.print(message + value1 + " " + value2);
    }
}