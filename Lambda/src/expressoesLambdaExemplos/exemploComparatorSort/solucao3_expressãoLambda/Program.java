package expressoesLambdaExemplos.exemploComparatorSort.solucao3_expressãoLambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        //Expressão Lambda
        Comparator<Product> comp =
        (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        list.sort(comp);

        //Ou também pode usar assim
        //list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));


        for (Product p : list) {
            System.out.println(p);
        }
    }
}
