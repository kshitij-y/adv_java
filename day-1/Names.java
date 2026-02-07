
import java.util.ArrayList;
import java.util.List;

public class Names {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kshitij");
        names.add("Avinash");
        names.add("BabalPreet");
        names.add("Kabir");
        names.add("kumar");

        for(String name : names){
            System.out.println(name);
        }
    }
}