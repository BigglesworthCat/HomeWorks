package Model;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Groups {
    KA_91, DA_92, BI_93, FI_94;

    private static final ResourceBundle res = ResourceBundle.getBundle("NoteFieldsNames", new Locale("en"));

    public String toString() { return res.getString("enum." + name() + ".string"); }

    public static boolean contains(String str)
    {
        for (Groups c : Groups.values()) {
            if (c.name().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
