package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class NoteBook{
    private Map<String, String> info = new HashMap<>();

    NoteBook(String[] fields_key, String[] fields_value)
    {
        for(int i=0; i< fields_value.length; i++)
        {
            info.put(fields_key[i], fields_value[i]);
        }
    }

    /**
     * Put element in Map
     * @param key - key for Map
     * @param value - value for Map
     */
    public void putField(String key, String value)
    {
        info.put(key, value);
    }

    public String getField(String key)
    {
        return info.get(key);
    }
}
