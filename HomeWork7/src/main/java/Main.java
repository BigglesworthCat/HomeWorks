import Controller.*;
import Model.*;
import View.*;

import java.text.ParseException;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}