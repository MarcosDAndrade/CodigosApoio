package DemoFuncaoRecebendoOutraFuncao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {
        List<ProductDemo> list = new ArrayList<>();

        list.add(new ProductDemo("Tv", 900.00));
        list.add(new ProductDemo("Mouse", 50.00));
        list.add(new ProductDemo("Tablet", 350.50));
        list.add(new ProductDemo("HD Case", 80.90));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p->p.getName().charAt(0) == 'H');
        double sum2 = ps.filteredSum(list, p->p.getPrice()<=100);

        System.out.println(sum);
        System.out.println(sum2);
    }
}
