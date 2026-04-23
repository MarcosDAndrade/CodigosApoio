package expressoesLambdaExemplos.exemploConsumerUpdate.solucao1;

import java.util.function.Consumer;

public class PriceUpdate implements Consumer<Product> {

    //Atualizar o valor aumentando em 10%
    @Override
    public void accept(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }
}
