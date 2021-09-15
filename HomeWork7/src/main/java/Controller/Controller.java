package Controller;

import Model.*;
import Model.Organization.Department;
import Model.Organization.Worker;
import View.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Dmytro Kriuchkov
 * @version 1.1
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

        view.printMessage("--===Deleting and adding workers===--\n");
        deleteWorkerInDepartment(utilityController);
        addWorkerToDepartment(utilityController, new Worker("Daniil", "Kleshchev", "Mihailovich", 700, new GregorianCalendar(2003, Calendar.APRIL, 18), new GregorianCalendar(20, Calendar.NOVEMBER, 17)));

        view.printMessage("--===Recalculating salaries===--\n");
        recalculateSalaries(utilityController);

        view.printMessage("--===Birthday bonus salaries===--\n");
        model.giveBirthdayBonus();

        view.printMessage("--===Sorting workers===--\n");
        sortWorkers(utilityController);
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
     * With help of UtilityController we choose department where we want to place worker
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
        for(Department dep: model.getDepartments())
        {
            view.printMessage("Department: " + dep.getDepartmentName() + "\n");

            boolean res = utilityController.chooseRecalculating();
            dep.recalculateSalaries(res);
        }
    }

    /**
     * With help of UtilityController we choose department where we want to sort worker and choose way of their sorting
     * @param utilityController - object of UtilityController class
     * @see UtilityController#chooseDepartment()
     * @see UtilityController#chooseSorting()
     * @see Department#sort(boolean)
     */
    void sortWorkers(UtilityController utilityController)
    {
        int dep_num = utilityController.chooseDepartment(); //Get index of department with which we'll work
        boolean res = utilityController.chooseSorting(); //Choose way of sorting (by surname or hiring day)
        model.getDepartments().get(dep_num).sort(res);
    }

}