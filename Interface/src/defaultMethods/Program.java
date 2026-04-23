package defaultMethods;

import defaultMethods.Services.BrazilInterestService;
import defaultMethods.Services.InterestService;
import defaultMethods.Services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Amount: ");
        double amount = sc.nextDouble();
        System.out.println("Months: ");
        int months = sc.nextInt();

        InterestService is = new BrazilInterestService(2.0);
        InterestService us = new UsaInterestService(1.0);
        double payment = is.payment(amount, months);
        double payment2 = us.payment(amount, months);


        System.out.println("Payment after " + months + " months: ");
        System.out.println(String.format("%.2f", payment));
        System.out.println(String.format("%.2f", payment2));

        sc.close();
    }
}
