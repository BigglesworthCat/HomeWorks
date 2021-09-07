package Model;

import Controller.FieldException;
import Controller.InputNoteBook;

import java.util.ArrayList;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.0
 */

public class Model {
    public ArrayList<NoteBook> noteDB = new ArrayList<>();

    public void addToNoteDB(InputNoteBook input) throws FieldException
    {
        NoteBook note = new NoteBook(input.fields_key, input.fields_value);

        String fieldToCheck = "Nickname";
        for(NoteBook n: noteDB)
        {
            String existing_field = n.getField(fieldToCheck);
            String cur_field = note.getField(fieldToCheck);

            if(cur_field.equals(existing_field))
            {
                throw new FieldException(fieldToCheck, "input.fieldException");
            }
        }
        noteDB.add(note);
    }
}