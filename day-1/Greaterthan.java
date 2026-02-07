
import java.util.List;


public class Greaterthan {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,45,56,67,78,90);
        
        System.out.println((list.stream().filter(n -> n > 50).count()));
    }
}
