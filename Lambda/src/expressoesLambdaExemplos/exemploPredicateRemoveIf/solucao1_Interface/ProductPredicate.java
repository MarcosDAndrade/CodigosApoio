package expressoesLambdaExemplos.exemploPredicateRemoveIf.solucao1_Interface;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
}
