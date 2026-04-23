package Set.Exercicio;

import com.sun.source.tree.Tree;

import java.util.*;

public class Exercicio {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> alunos = new TreeSet<>();

        System.out.print("How many students for course A?: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int cod = sc.nextInt();
            alunos.add(cod);
        }
        System.out.print("How many students for course B?: ");
        n = sc.nextInt();
        for (int i=0;i<n;i++){
            int cod = sc.nextInt();
            alunos.add(cod);
        }
        System.out.print("How many students for course C?: ");
        n = sc.nextInt();
        for (int i=0;i<n;i++){
            int cod = sc.nextInt();
            alunos.add(cod);
        }

        Set<Integer> e = new TreeSet<>(alunos);
        e.retainAll(alunos);
        System.out.println("Total de alunos: " + e.size());

        sc.close();


    }
}
