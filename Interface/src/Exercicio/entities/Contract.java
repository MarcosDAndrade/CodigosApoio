package Exercicio.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalValue;

    public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private List<Installment> instalments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstalments() {
        return instalments;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number=" + number +
                ", date=" + sdf.format(date) +
                ", totalValue=" + totalValue +
                '}';
    }
}
