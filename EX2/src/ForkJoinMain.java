

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinMain {
    static ArrayList<String> list1 = new ArrayList<>(Arrays.asList("*","%","3","#","6","~","!","2"));
    static ArrayList<String> list2 = new ArrayList<>(Arrays.asList("&", "¥", "@", "1","4", ":", "2","1"));

    static ArrayList<String> list3 =
            new ArrayList<>(
                    Arrays.asList("and", "with", "we", "me", "university", "with", "book", "computer", "country", "book"));
    static ArrayList<String> list4 =
            new ArrayList<>(
                    Arrays.asList("bag", "boy", "book", "school", "teacher", "student", "book", "book"));

    public static void main(String[] args) {
//        problem1();
        problem2();
    }

    public static void problem1()
    {
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<String> task1 = new ListSum(list1, 0, list1.size()-1);
        String result1 = pool.invoke(task1);
        System.out.println("Fork/join sum: " + result1);

        ForkJoinTask<String> task2 = new ListSum(list2, 0, list2.size()-1);
        String result2 = pool.invoke(task2);
        System.out.println("Fork/join sum: " + result2);
    }

    public static void problem2()
    {
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Integer> task1 = new StringCheck(list3, 0, list3.size()-1);
        Integer result1 = pool.invoke(task1);
        System.out.println("Fork/join count File1: " + result1);

        ForkJoinTask<Integer> task2 = new StringCheck(list4, 0, list4.size()-1);
        Integer result2 = pool.invoke(task2);
        System.out.println("Fork/join count File2: " + result2);

        System.out.println("Fork/join total count:" + (result1+result2));
    }
}
