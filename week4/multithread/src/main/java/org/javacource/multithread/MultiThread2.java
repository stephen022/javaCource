package org.javacource.multithread;


import java.util.concurrent.*;

/**
 * 方法1：通过线程池方式
 *
 */
public class MultiThread2 {

    private static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return sum();
            }
        }
    };

    public static void main(String[] args) {



        long start=System.currentTimeMillis();


        // 在这里创建线程池，
        MyCallable task = new MyCallable();
        try {
            //可缓存线程池
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future future = executorService.submit(task);
            Integer result = (Integer)future.get();

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
