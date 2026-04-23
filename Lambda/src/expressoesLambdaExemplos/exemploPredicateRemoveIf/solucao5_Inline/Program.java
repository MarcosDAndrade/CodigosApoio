package expressoesLambdaExemplos.exemploPredicateRemoveIf.solucao5_Inline;

import java.util.ArrayList;
import java.util.List;

public class Program {
    static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //Expressão normal
       // list.removeIf(p->p.getPrice()>=100);

        //Expressão com o Method Reference
        //list.removeIf(Product::nonstaticProductPredicate);

        //Lambda na mesma linha da função
        list.removeIf(p -> p.getPrice()>100);

            for (Product p : list){
                System.out.println(p);
            }
    }
}
