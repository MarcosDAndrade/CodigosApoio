package Stream.exercicioFixacao;

import java.util.List;
import java.util.function.Predicate;

public class FilterService {
    public double filterSalary (List<Employee> employee, Predicate<Employee> criteria){
        double sum = 0.0;

        for (Employee emp : employee){
            if (criteria.test(emp)){
                sum += emp.getSalary();
            }
        }
        return sum;
    }

}
