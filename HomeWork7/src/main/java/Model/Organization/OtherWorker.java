package Model.Organization;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Class for worker like administration or clerks
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class OtherWorker extends Worker {
    String info;

    public OtherWorker(String name, String surname, String patronymic, double salary, Calendar birthday, Calendar workStart, String info) throws ParseException {
        super(name, surname, patronymic, salary, birthday, workStart);
        this.info = info;
    }
}
