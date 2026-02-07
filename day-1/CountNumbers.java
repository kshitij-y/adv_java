
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CountNumbers {
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,3,4,5,5,6,6,6,7,8,9));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");

        int n = sc.nextInt();
        int count = 0;
        for(int i:list){
            if(i == n){
                count++;
            }
        }

        System.out.println("Count: " + count);

        sc.close();
    }
}
