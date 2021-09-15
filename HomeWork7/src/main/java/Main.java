import Controller.*;
import Model.*;
import Model.Organization.Department;
import Model.Organization.Manager;
import Model.Organization.Worker;
import View.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Creating and pushing workers to array
        ArrayList<Worker> mass = new ArrayList<>();
        mass.add(new Worker("Dima", "Kriuchkov", "Oleksandrovich", 800, new GregorianCalendar(2002, Calendar.SEPTEMBER, 17), new GregorianCalendar(2021, Calendar.NOVEMBER, 21)));
        mass.add(new Worker("Daniil", "Kleshchev", "Mihailovich", 800, new GregorianCalendar(2003, Calendar.APRIL, 18), new GregorianCalendar(2021, Calendar.NOVEMBER, 20)));
        mass.add(new Worker("Illya", "Ilnistkiy", "Vladislavovich", 800, new GregorianCalendar(2004, Calendar.SEPTEMBER, 19), new GregorianCalendar(2021, Calendar.NOVEMBER, 18)));
        mass.add(new Worker("Nazar", "Andrushko", "Oleksandrovich", 600, new GregorianCalendar(2005, Calendar.JUNE, 20), new GregorianCalendar(2021, Calendar.NOVEMBER, 23)));

        Manager manager = new Manager("Tymofiy", "Skripko", "Iouriyovytch", 1000, new GregorianCalendar(2001, Calendar.JULY, 21), new GregorianCalendar(20, Calendar.NOVEMBER, 17), mass);

        model.addDepartment(new Department("Central Department", manager));

        // Run
        controller.processUser();
    }
}