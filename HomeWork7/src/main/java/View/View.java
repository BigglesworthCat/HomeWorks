package View;

/**
 * @author Dmytro Kriuchkov
 * @version 1.1
 */
public class View {
    public static String SUBJECTS_LIST = "List of workers in this department (name, surname, salary):\n";
    public static String DEPARTMENTS_LIST = "List of departments (name, fund, salaries):\n";

    public static String ENTER_WORKER_NUMBER = "Enter number of worker you want to fire: ";
    public static String ENTER_DEPARTMENT_NUMBER = "Enter number of department you want to work with: ";
    public static String ENTER_RECALCULATING = "What way of recalculating use? (Uniform/Proportionally) ";
    public static String ENTER_SORTING = "What criterion use? (Surname/Hiring) ";


    public static String WRONG_INPUT = "Please enter correct worker number: ";
    public static final String NOT_INT = "Wrong type! Please, enter integer number: ";
    public static final String WRONG_RECALCULATING = "Please, enter your answer again (Uniform/Proportionally): ";
    public static final String WRONG_SORTING = "Please, enter your answer again (Surname/Hiring): ";

    public void printMessage(String massage)
    {
        System.out.print(massage);
    }
}
