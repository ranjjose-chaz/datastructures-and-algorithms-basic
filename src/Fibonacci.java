import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static Map<Integer, Integer> cache = new HashMap<>();


    public static void main(String[] args) {
        printFibonacci(60);
    }

    private static void printFibonacci(int count) {
        for(int i=1; i<=count; ++i){
            System.out.print(getFibonacci(i) + ", ");
        }
    }



    public static int getFibonacci(int index) {

        if(index == 0)
            throw new NotImplementedException();
        else if(index == 1)
            return 0;
        else if(index == 2)
                return 1;
        else if(cache.get(index) == null)
            cache.put(index, getFibonacci(index-1) + getFibonacci(index-2));
        return cache.get(index);



    }
}
