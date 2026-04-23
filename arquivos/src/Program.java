import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main() {
        File file = new File("\"C:\\Users\\marcfilh\\Desktop\\in.txt\"");
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException e ){
            System.out.println("Error: " + e.getCause());
        }
        finally {
            //Scanner não pode ser fechado nulo
            if (sc != null){
                sc.close();
            }
        }
    }
}
