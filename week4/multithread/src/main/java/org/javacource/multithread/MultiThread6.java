package org.javacource.multithread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方法1：通过Runable,线程join方式
 *
 */
public class MultiThread6 {
    private final static int min = 2;
    private final static int max = 4;
    private static int result;

    private static class MyRunable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                result = sum();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {



        long start=System.currentTimeMillis();


        // 在这里创建线程池，
        MyRunable task = new MyRunable();
        try {
            Thread thread = new Thread(task);
            thread.start();
            thread.join();
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + result);

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }catch (Exception e){
            e.printStackTrace();
        }

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
