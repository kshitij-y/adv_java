package main.com.age;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        StudentService ss = new StudentService();
        System.out.println(ss.isEligible(age));
    }
}
