package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        //Hashset é o mais rápido, mas nem sempre sai na ordem que foi adicionado
        //Indicado quando a ordem do programa não importa
        Set<String> set = new HashSet<>();

        //Ordenado alfabeticamente (maiusculo vem antes), porém mais lento para processar
        Set<String> set1 = new TreeSet<>();

        //Mantém a ordem que foram inseridos
        Set<String> set2= new LinkedHashSet<>();


        set.add("TV");
        set.add("Tablet");
        set.add("Notebook");

        set1.add("TV");
        set1.add("Tablet");
        set1.add("Notebook");

        set2.add("TV");
        set2.add("Tablet");
        set2.add("Notebook");

        System.out.println(set.contains("Notebook"));
        set.remove("Tablet");
        set.removeIf(x -> x.length() >= 3);
        set1.removeIf(x -> x.charAt(0) == 'T');
        System.out.println("Fora de ordem");
        for (String p : set) {
            System.out.println(p);
        }
        System.out.println("");

        System.out.println("Ordenado");
        for (String p : set1) {
            System.out.println(p);
        }
        System.out.println("");

        System.out.println("Ordenado na ordem que foram colocados");
        for (String p : set2) {
            System.out.println(p);
        }
        System.out.println("");
    }
}
