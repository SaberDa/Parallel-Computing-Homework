
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class StringCheck extends RecursiveTask<Integer> {

    static final int Threshold = 4;
    ArrayList<String> list;
    int start;
    int end;

    StringCheck(ArrayList<String> _list, int _start, int _end)
    {
        this.list = _list;
        this.start = _start;
        this.end = _end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) < Threshold)
        {
            Integer sum = 0;

            for (int i = start; i <= end; ++i)
            {
                if ("book".equals(list.get(i)))
                    sum ++;
            }
            return sum;
        }
        int middle = (end + start)/2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle+1, end));
        StringCheck subtask1 = new StringCheck(this.list, start, middle);
        StringCheck subtask2 = new StringCheck(this.list, middle+1, end);
        invokeAll(subtask1, subtask2);
        Integer subresult1 = subtask1.join();
        Integer subresult2 = subtask2.join();
        Integer result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}
