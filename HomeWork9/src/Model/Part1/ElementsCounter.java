package Model.Part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ElementsCounter {

    public static <T> HashMap<T, Integer> countElements(ArrayList<T> array)
    {
        HashMap<T, Integer> result = new HashMap<>();

        for(T i: array)
        {
            if(result.containsKey(i))
            {
                result.replace(i, result.get(i) + 1);
            }
            else
            {
                result.put(i, 1);
            }
        }

        return result;
    }
}
