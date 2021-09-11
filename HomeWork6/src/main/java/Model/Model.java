package Model;

import java.util.HashMap;
import java.util.Map;

public class Model {
    public void testClasses()
    {
        System.out.println("-= Student =-");
        Student st = new Student("Dima", 19, "KA-94");
        System.out.println("Student object hash-code: " + st.hashCode());

        System.out.println("\n-= ImmutableBottle =-");
        Map<String, Double> tmp = new HashMap<>();
        tmp.put("Sugar", 0.5);
        ImmutableBottle bottle = new ImmutableBottle("Sphere", "Green", 2.0, tmp);
        bottle.print();

        System.out.print("\nCreating new object by using set-method:");
        tmp.put("Glucose", 0.25);
        bottle.setContent(tmp).print();

        System.out.print("\nOriginal object:");
        bottle.print();
    }
}