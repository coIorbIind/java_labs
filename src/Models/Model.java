package Models;

import Classes.*;
import Controllers.Controller;
import Views.View;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Model {

    /**
     * Reading file
     * @return new laundry, loaded from file
     * @throws java.io.IOException - errors while reading file
     */
    public static Laundry ReadFile() throws java.io.IOException{
        Laundry laundry = new Laundry();
        File laundryFile = new File("C:\\Users\\admin\\IdeaProjects\\Lab_3\\src\\files\\laundry.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(laundryFile);
            int n = scanner.nextInt();
            for (int i=0; i<n; i++){
                String powder = scanner.next();
                String fabric_softener = scanner.next();
                Color color = Color.valueOf(scanner.next());
                Temperature temp = Temperature.valueOf(scanner.next());
                int size = scanner.nextInt();
                ArrayList<ColoredLinen> clothes = new ArrayList<ColoredLinen>();
                for (int j=0; j<size; j++)
                {
                    clothes.add(new ColoredLinen(Temperature.valueOf(scanner.next()), scanner.nextInt(), Color.valueOf(scanner.next())));
                }
                laundry.AddMachine(new WashingMachine(powder, fabric_softener, color, temp, clothes));
            }
            }
        catch (FileNotFoundException e) {
             View.Out("Файл не найден!");
        }
        return laundry;
    }

}
