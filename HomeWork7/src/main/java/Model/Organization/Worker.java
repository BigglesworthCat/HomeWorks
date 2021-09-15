package Model.Organization;

import java.text.ParseException;
import java.util.Calendar;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Worker {
    private String name;
    private String surname;
    private String patronymic;
    private double salary;
    private Calendar birthday;
    private Calendar workStart;

    private boolean bonus;

    public Worker(String name, String surname, String patronymic, double salary, Calendar birthday, Calendar workStart) throws ParseException
    {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
        this.birthday = birthday;
        this.workStart = workStart;
        this.bonus = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setWorkStart(Calendar workStart) {
        this.workStart = workStart;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public double getSalary() {
        return salary;
    }

    public int getBirthdayMonth() {
        return birthday.get(Calendar.MONTH);
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public Calendar getWorkStart() {
        return workStart;
    }

    public boolean isBonus() {
        return bonus;
    }
}
