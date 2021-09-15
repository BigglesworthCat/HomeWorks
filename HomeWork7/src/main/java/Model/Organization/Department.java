package Model.Organization;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Dmytro Kriuchkov
 * @version 1.1
 */
public class Department {
    String departmentName;
    double fund;
    double salaries;
    Manager manager;

    public Department(String departmentName, Manager manager)
    {
        this.departmentName = departmentName;
        this.manager = manager;

        double tmp_salaries = 0;
        for(Worker sub : this.manager.getSubject())
        {
            tmp_salaries += sub.getSalary(); //Summing salaries of all manager's subjects
        }

        this.salaries = tmp_salaries + this.manager.getSalary();
        this.fund = this.salaries * 2.5; //Let fund be bigger than salaries in 2.5 times
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public double getFund() {
        return this.fund;
    }

    public double getSalaries() {
        return this.salaries;
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setSalaries(double salaries) {
        this.salaries = salaries;
    }

    public ArrayList<Worker> getSubjects() {
        return this.manager.getSubject();
    }

    public void addSubject(Worker worker)
    {
        salaries += worker.getSalary();
        fund += worker.getSalary()*2;
        manager.addSubject(worker);
    }

    public void deleteSubject(int number)
    {
        salaries -= manager.getSubject().get(number).getSalary();
        manager.removeSubject(number);
    }


    public void recalculateSalaries(boolean res)
    {
        if(fund<=salaries)
        {
            return;
        }
        ArrayList<Worker> subjects = manager.getSubject();
        double additionalSalaries = (fund - salaries) * 0.2; //20% of unused fund will be recalculated
        fund = fund - additionalSalaries; //Reduce fund in measure recalculated salaries

        if(res) //If we chose uniform distribution
        {
            manager.setSalary(manager.getSalary() + additionalSalaries * 0.3); //Let manager get 30% of every subject additional salaries
            //Other 70% wil be distributed between workers

            double everyWorkerAddSalary = additionalSalaries * 0.7 / subjects.size();

            for(Worker sub: subjects)
            {
                sub.setSalary(sub.getSalary() + everyWorkerAddSalary);
            }
        }
        else //If we chose proportional distribution
        {
            manager.setSalary(manager.getSalary() * ( 1 + additionalSalaries / salaries)); //Set new manager salary in proportion

            for(Worker sub: subjects)
            {
                sub.setSalary(sub.getSalary() * ( 1 + additionalSalaries / salaries));
            }
        }
        salaries = salaries + additionalSalaries; //New salaries size
    }

    public void sort(boolean res)
    {
        if(res) //Sorting by Surname
        {
            manager.getSubject().sort(Comparator.comparing(Worker::getSurname));
        }
        else //Sorting by hiring day
        {
            manager.getSubject().sort(Comparator.comparing(Worker::getWorkStart));
        }
    }
}
