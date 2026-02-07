import java.util.HashMap;
import java.util.Map;

public class EmployeeID {
    public static void main(String[] args) {
        Map<Integer,String> emp = new HashMap<>();

        emp.put(1, "KShitij");
        emp.put(2, "avinash");
        emp.put(2, "Babal");

        for (Map.Entry<Integer,String> en : emp.entrySet()) {
            Integer key = en.getKey();
            String val = en.getValue();

            System.out.println("Key: " + key + " value: " + val);
            
        }

    }
}
