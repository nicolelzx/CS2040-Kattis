import java.util.*;
import java.lang.*;

public class Autori {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split("-");
        String result = "";
        
        for (int i=0; i < arr.length; i++) {
            String name = arr[i];
            result += name.charAt(0);
        }
        
        System.out.println(result);
    }
}