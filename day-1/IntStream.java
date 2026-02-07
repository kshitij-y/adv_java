
import java.util.List;


public class IntStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7);

        list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
    }
}
