import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;

public class HandleList extends RecursiveTask<String> {

    static final int Threshold = 2;
    ArrayList<String> list;
    int start;
    int end;

    HandleList(ArrayList<String> _list, int _start, int _end) {
        this.list = _list;
        this.start = _start;
        this.end = _end;
    }

    @Override
    protected String compute() {
        if ((end - start) < Threshold) {
            Integer sum = 0;
            if (isNumeric(list.get(end))) {
                sum += Integer.parseInt(list.get(end));
            } else if (isNumeric(list.get(start))) {
                sum += Integer.parseInt(list.get(start));
            }
            return sum.toString();
        }

        int middle = (end + start)/2;
        System.out.println(String.format("划分结果：%d~%d, %d~%d", start, middle, middle+1, end));
        HandleList subtask1 = new HandleList(this.list, start, middle);
        HandleList subtask2 = new HandleList(this.list, middle+1, end);
        invokeAll(subtask1, subtask2);
        String subresult1 = subtask1.join();
        String subresult2 = subtask2.join();
        Integer result = Integer.parseInt(subresult1) + Integer.parseInt(subresult2);
        return result.toString();
    }

    //利用正则表达式判断是否为数字
    public static boolean isNumeric (String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
