package Controller;

import Model.Organization.Department;
import Model.Model;
import Model.Organization.Worker;
import View.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */

public class UtilityController {
    private final Scanner scanner;
    private final View view;
    private final Model model;

    public UtilityController(Scanner scanner, View view, Model model) {
        this.scanner = scanner;
        this.view = view;
        this.model = model;
    }


    int inputInt()
    {
        while(!scanner.hasNextInt()){
            view.printMessage(View.NOT_INT);
            scanner.next();
        }
        return scanner.nextInt();
    }

    int chooseDepartment()
    {
        ArrayList<Department> departments = model.getDepartments();

        view.printMessage(View.DEPARTMENTS_LIST);

        for(int i=0; i< departments.size(); i++)
        {
            view.printMessage(i+1 + ". " + departments.get(i).getDepartmentName() + " " + departments.get(i).getFund() + " " + departments.get(i).getSalaries() + "\n");
        }

        view.printMessage(View.ENTER_DEPARTMENT_NUMBER);

        int number = inputInt();
        while ( !(1 <= number & number <= departments.size()) ){
            view.printMessage(View.WRONG_INPUT);
            number = inputInt();
        }
        return (number - 1);
    }

    int chooseWorker(int dep_num)
    {
        Department department = model.getDepartments().get(dep_num);
        ArrayList<Worker> subjects = department.getSubjects();

        view.printMessage(View.SUBJECTS_LIST);

        for(int i=0; i< subjects.size(); i++)
        {
            System.out.println(i+1 + ". " + subjects.get(i).getName() + " " + subjects.get(i).getSurname() + " " + subjects.get(i).getSalary());
        }

        view.printMessage(View.ENTER_WORKER_NUMBER);

        int number = inputInt();
        while ( !(1 <= number & number <= subjects.size()) ){
            view.printMessage(View.WRONG_INPUT);
            number = inputInt();
        }

        return (number - 1);
    }

    boolean chooseRecalculating()
    {
        view.printMessage(View.ENTER_RECALCULATING);
        String res;
        while (true)
        {
            res = scanner.next();
            if (res.equalsIgnoreCase("Uniform"))
            {
                return true;
            }
            else if(res.equalsIgnoreCase("Proportionally"))
            {
                return false;
            }
            view.printMessage(View.WRONG_RECALCULATING);
        }
    }
}