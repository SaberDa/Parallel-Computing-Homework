package com.fork;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Map<String, Integer> map = forkJoinPool.invoke(new com.fork.ForkRecursiveTask("C:\\Users\\Saberda\\Desktop\\1.txt"));
        //输出最终所有的计算结果
        for(String key : map.keySet()){
            System.out.println(key + "=" + map.get(key));
        }
    }
}