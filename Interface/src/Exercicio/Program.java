package Exercicio;

import Exercicio.entities.Contract;
import Exercicio.entities.Installment;
import Exercicio.services.ContractService;
import Exercicio.services.PayPalServive;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Installment> parcelas = new ArrayList<>();

        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Digite a data do contrato (dd/MM/yyyy): ");
        sc.nextLine();
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Digite o valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PayPalServive());

        contractService.processContract(obj, n);

        System.out.println("Parcelas");
        for (Installment installment : obj.getInstalments()){
            System.out.println(installment);
        }




        sc.close();
    }
}
