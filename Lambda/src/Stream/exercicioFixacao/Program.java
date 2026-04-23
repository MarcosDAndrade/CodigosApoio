package Stream.exercicioFixacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String path = "C:\\Users\\marcfilh\\Desktop\\Uteis\\Curso Java Completo\\CodigosApoio\\Lambda\\src\\Stream\\exercicioFixacao\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] field = line.split(",");
                list.add(new Employee(field[0], field[1], Double.parseDouble(field[2])));
                line = br.readLine();
            }

            System.out.println("Enter salary: ");
            int s = sc.nextInt();

            Comparator<String> comp = (e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase());
            List<String> emails = list.stream()
                    .filter(e -> e.getSalary() > s)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            FilterService fs = new FilterService();

            double empSalary = fs.filterSalary(list, e -> e.getName().charAt(0) == 'M');

            emails.forEach(System.out::println);
            System.out.println("A soma dos salários cujo funcionário tem a letra M é: " + empSalary);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
