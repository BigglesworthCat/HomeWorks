package View;

import java.util.Map;

public class View {
    public static String DDDD = "List of workers in this department (name, surname, salary):\n";

    public void printMessage(String massage)
    {
        System.out.print(massage);
    }

    public <T, V> void printMap(Map<T, V> map)
    {
        System.out.println("This map contains: (value, count)");
        for (Map.Entry<T, V> entry : map.entrySet()) {
            System.out.println("Number " + entry.getKey() + " was met " + entry.getValue().toString() + " times");
        }
    }
}