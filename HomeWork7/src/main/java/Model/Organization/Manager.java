package Model.Organization;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class Manager extends Worker {
    ArrayList<Worker> subjects = new ArrayList<>();

    public Manager(String name, String surname, String patronymic, double salary, Calendar birthday, Calendar workStart, ArrayList<Worker> subject) throws ParseException
    {
        super(name, surname, patronymic, salary, birthday, workStart);
        this.subjects = subject;
    }

    public void addSubject(Worker worker)
    {
        subjects.add(worker);
    }

    public void removeSubject(int number)
    {
        this.subjects.remove(number);
    }

    public ArrayList<Worker> getSubject() {
        return subjects;
    }

    /**
     * This method demote manager to worker
     * @return Worker
     * @throws ParseException
     */
    public Worker demotion() throws ParseException {
        return new Worker(this.getName(), this.getSurname(), this.getPatronymic(), this.getSalary(), this.getBirthday(), this.getWorkStart());
    }

    public OtherWorker promotion(String info) throws ParseException {
        return new OtherWorker(this.getName(), this.getSurname(), this.getPatronymic(), this.getSalary(), this.getBirthday(), this.getWorkStart(), info);
    }
}
