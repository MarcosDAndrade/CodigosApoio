package segurancaDeTipo;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Define que tipo de valor meu programa irá aceitar,
        // no caso so aceita Integer ou int
        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values?: ");
        int n = sc.nextInt();


        for (int i=0;i<n;i++){
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());
    }
}
