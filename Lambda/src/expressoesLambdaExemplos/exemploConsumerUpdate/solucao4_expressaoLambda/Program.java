package expressoesLambdaExemplos.exemploConsumerUpdate.solucao4_expressaoLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Program {
    static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        Consumer<Product> cons = p->{
            p.setPrice(p.getPrice()*1.1);
        };

        list.forEach(cons);

        list.forEach(System.out::println);


    }
}
