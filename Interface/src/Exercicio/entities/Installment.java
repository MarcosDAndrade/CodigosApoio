package Exercicio.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate date;
    private double Amount;

    public Installment(){

    }

    public Installment(LocalDate date, double amount) {
        this.date = date;
        Amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }


    @Override
    public String toString() {
        return  date.format(fmt) +" - " + String.format("%.2f", Amount) ;
    }
}
