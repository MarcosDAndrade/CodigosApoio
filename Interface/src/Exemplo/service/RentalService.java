package Exemplo.service;

import Exemplo.entities.CarRental;
import Exemplo.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    //Calculando total, comparando as horas e multiplicando pelo valor.
    public void processInvoice(CarRental carRental){

       double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
       //achar quantas horas tem a duração entre os valores acima
        double hours = minutes/60;

       double basicPayment;
       if (hours <= 12){
           basicPayment = pricePerHour *Math.ceil(hours) ;
       } else {
           //Achar os dias de acordo com as horas: o Ceil arredonda pra cima
           basicPayment = pricePerDay *Math.ceil(hours/24) ;
       }

       double tax = taxService.tax(basicPayment);

            carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
