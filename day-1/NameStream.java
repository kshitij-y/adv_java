
import java.util.List;


public class NameStream {
    public static void main(String[] args) {
        List<String> names = List.of("kshitij", "Avinash", "Babal", "Kabir");
        
        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
    }
}
