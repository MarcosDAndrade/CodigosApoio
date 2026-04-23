package DemoFuncaoRecebendoOutraFuncao;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {
    public double filteredSum(List<ProductDemo> list, Predicate<ProductDemo> criteria){
        double sum = 0.0;

        for (ProductDemo p : list){
            if (criteria.test(p)){
                sum += p.getPrice();
            }
        }

        return sum;
    }
}
