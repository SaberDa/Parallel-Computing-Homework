package ForkJoinComputing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;


public class ForkJoinMain {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("*","%","3","#","6","~","!","2"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("&", "¥", "@", "1","4", ":", "2","1"));

        ForkJoinPool pool = new ForkJoinPool(8);
        ForkJoinTask<String> task1 = new ForkJoinComputing.ListSum(list1, 0, list1.size()-1);
        String result1 = pool.invoke(task1);
        System.out.println("Fork/join sum: " + result1);

        ForkJoinTask<String> task2 = new ForkJoinComputing.ListSum(list2, 0, list2.size()-1);
        String result2 = pool.invoke(task2);
        System.out.println("Fork/join sum: " + result2);
    }
}
