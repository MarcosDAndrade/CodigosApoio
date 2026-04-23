package interfaceComparable.TestandoCollectionSort;

import java.util.*;

public class TestCollectionsSort {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Pessoa> lista = new ArrayList<>();

        int n= sc.nextInt();

        sc.nextLine();
        for (int i=1;i<=n;i++){
            System.out.println(i);
            String name = sc.nextLine();
            list.add(name);
        }

        for (int i=1;i<=n;i++){
            System.out.println(i);
            String name = sc.nextLine();
            Pessoa p = new Pessoa(name);
            lista.add(p);
        }


        Collections.sort(list);
        for (String s: list){
            System.out.println(s);
        }

        Collections.sort(list);
        for (Pessoa s: lista){
            System.out.println(s);
        }

    }


}
