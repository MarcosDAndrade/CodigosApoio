package defaultMethods.Services;

import java.security.InvalidParameterException;

public interface InterestService {
    double getInterestRate();
    default double payment(double amount, int months){
        if (months < 1){
            throw new InvalidParameterException("Months must be greater than zero");
        }
        //math pow está fazendo 1+juros/100 multiplicado pelos meses que foi digitado
        return amount * Math.pow(1.0+getInterestRate()/100, months);
    }
}
