package View;

public class View {
    public static String MEAN_VALUE = "Array mean value is: ";
    public static String MIN_VALUE = "Minimal value: ";
    public static String EQUAL_TO_ZERO = "Number of elements equal to zero: ";
    public static String BIGGER_THAN_ZERO = "Number of elements bigger than zero: ";


    public void printMessage(String massage)
    {
        System.out.println(massage);
    }

    public static void printStructure(int[] array) {
        System.out.println("Array contains: ");
        for(int i: array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

}