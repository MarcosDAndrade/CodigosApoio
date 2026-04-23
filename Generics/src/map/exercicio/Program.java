package map.exercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    static void main(String[] args) {
        String path = "C:\\Users\\marcfilh\\Desktop\\in.txt";
        Map<String, Integer> votes = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line!=null){

                String [] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

               if (votes.containsKey(name)){
                   int votesSofar = votes.get(name);
                   votes.put(name, count + votesSofar);
               } else {
                   votes.put(name, count);
               }

               line = br.readLine();
            }

            for (String key:votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e ){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
