package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dmytro Kriuchkov
 * @version 1.0
 */
public class NoteBook{
    Map<String, String> info = new HashMap<>();

    /**
     * Put element in Map
     * @param key - key for Map
     * @param value - value for Map
     */
    public void putField(String key, String value)
    {
        info.put(key, value);
    }
}
