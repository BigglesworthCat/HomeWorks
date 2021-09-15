package Model;

import Model.Organization.Department;
import Model.Organization.Manager;
import Model.Organization.Worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Model {
    ArrayList<Department> departments = new ArrayList<>();

    public void addDepartment(Department department)
    {
        this.departments.add(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public Department getDepartmentInIndex(int number)
    {
        return departments.get(number);
    }

    public int getDepartmentsSize() {
        return departments.size();
    }

    public void deleteWorkerInDepartment(int dep_num, int worker_num)
    {
        departments.get(dep_num).deleteSubject(worker_num);
    }

    public void addWorkerToDepartment(int dep_num, Worker worker)
    {
        departments.get(dep_num).addSubject(worker);
    }

    public void giveBirthdayBonus()
    {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int currentMonth = cal.get(Calendar.MONTH);

        for(Department dep: departments)
        {
            Manager man = dep.getManager();
            if(currentMonth == man.getBirthdayMonth())
            {
                dep.setSalaries(dep.getSalaries() - 100);
                man.setBonus(true);
            }
            for(Worker worker: man.getSubject())
            {
                if(currentMonth == worker.getBirthdayMonth())
                {
                    dep.setSalaries(dep.getSalaries() - 100);
                    worker.setBonus(true);
                }
            }
        }
    }
}
