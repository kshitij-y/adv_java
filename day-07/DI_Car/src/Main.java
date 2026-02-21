import org.Entity.Car;
import org.Entity.DieselEngine;
import org.Entity.Engine;
import org.Entity.PetrolEngine;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Car gla200 = new Car();
        Engine eng = null;

        System.out.print("Enter engine type \n1. Petrol \n2. Diesel \nChoice: ");
        byte choice = sc.nextByte();

        switch (choice){
            case 1: {
                eng = new PetrolEngine();
                break;
            }
            case 2: {
                eng = new DieselEngine();
                break;
            }
        }
        // Field Injection
        //gla200.engine = eng;
        //gla200.engine.run();
        //System.out.println(gla200.engine.getClass());

        //Setter Injection
        gla200.setEngine(eng);
        gla200.getEngine().run();
        System.out.println(gla200.getEngine().getClass());


        // Constructor Injection
        Car amg = new Car(eng);
        amg.getEngine().run();
        System.out.println(amg.getEngine().getClass());

    }
}