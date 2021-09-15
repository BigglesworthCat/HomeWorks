package Controller;

import Model.*;
import Model.Organization.Department;
import Model.Organization.Manager;
import Model.Organization.Worker;
import View.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser() throws ParseException {

        Scanner scanner = new Scanner(System.in);
        UtilityController utilityController = new UtilityController(scanner, view, model);

        //Creating and pushing workers to array
        ArrayList<Worker> mass = new ArrayList<>();
        mass.add(new Worker("Dima", "Kriuchkov", "Oleksandrovich", 800, new GregorianCalendar(2002, Calendar.SEPTEMBER, 17), new GregorianCalendar(2021, Calendar.NOVEMBER, 17)));
        mass.add(new Worker("Daniil", "Kleshchev", "Mihailovich", 800, new GregorianCalendar(2003, Calendar.APRIL, 18), new GregorianCalendar(2021, Calendar.NOVEMBER, 17)));
        mass.add(new Worker("Illya", "Ilnistkiy", "Vladislavovich", 800, new GregorianCalendar(2004, Calendar.SEPTEMBER, 19), new GregorianCalendar(2021, Calendar.NOVEMBER, 17)));
        mass.add(new Worker("Misha", "Shevchenko", "Oleksandrovich", 600, new GregorianCalendar(2005, Calendar.JUNE, 20), new GregorianCalendar(2021, Calendar.NOVEMBER, 17)));

        Manager manager = new Manager("Tymofiy", "Skripko", "Iouriyovytch", 1000, new GregorianCalendar(2001, Calendar.JULY, 21), new GregorianCalendar(20, Calendar.NOVEMBER, 17), mass);

        model.addDepartment(new Department("Central Department", manager));

        view.printMessage("--===Deleting and adding workers===--\n");

        deleteWorkerInDepartment(utilityController);
        addWorkerToDepartment(utilityController, new Worker("Daniil", "Kleshchev", "Mihailovich", 700, new GregorianCalendar(2003, Calendar.APRIL, 18), new GregorianCalendar(20, Calendar.NOVEMBER, 17)));

        view.printMessage("--===Recalculating salaries===--\n");


        recalculateSalaries(utilityController);

        view.printMessage("--===Birthday bonus salaries===--\n");

        model.giveBirthdayBonus();


    }

    /**
     *With help of UtilityController we choose department and worker that we want to fire
     * @param utilityController - - object of UtilityController class
     * @see UtilityController#chooseDepartment()
     * @see UtilityController#chooseWorker(int)
     * @see Model#deleteWorkerInDepartment(int, int)
     */
    void deleteWorkerInDepartment(UtilityController utilityController)
    {
        int dep_num = utilityController.chooseDepartment(); //Get index of department with which we'll work
        int worker_num = utilityController.chooseWorker(dep_num); //Get index of worker in department with which we'll work
        model.deleteWorkerInDepartment(dep_num, worker_num);
    }

    /**
     *With help of UtilityController we choose department where we want to place worker
     * @param utilityController - object of UtilityController class
     * @param worker - object of Worker class
     * @see UtilityController#chooseDepartment()
     * @see Model#addWorkerToDepartment(int, Worker)
     */
    void addWorkerToDepartment(UtilityController utilityController, Worker worker)
    {
        int dep_num = utilityController.chooseDepartment(); //Get index of department with which we'll work
        model.addWorkerToDepartment(dep_num, worker);
    }

    /**
     * We iterate all departments and or each of them choose how to recalculate salaries
     * @param utilityController - object of UtilityController class
     * @see UtilityController#chooseRecalculating() 
     * @see Department#recalculateSalaries(boolean)
     */
    void recalculateSalaries(UtilityController utilityController)
    {
        ArrayList<Department> departments = model.getDepartments();

        for(Department dep: departments)
        {
            view.printMessage("Department: " + dep.getDepartmentName() + "\n");

            boolean res = utilityController.chooseRecalculating();
            dep.recalculateSalaries(res);
        }
    }
}