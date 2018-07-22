package main.java.thread_plus.callable_inc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 使用Callable接口新建线程
 * @author: jxy
 * @create: 2018-07-22 13:10
 */
//@SuppressWarnings("unchecked")
public class Thread_Demo_02 {

    public static void main(String[] args) throws InterruptedException{
//        FutureTask ft = new FutureTask(() -> {
//            // 使用lambda表达式重写Callable 接口的 call()方法,
//            System.out.println(
//                    "call方法开始执行 ... \n" +
//                    "下面开始介绍如何使用Callable接口来新建线程\n" +
//                    "\t\tFutureTask类实现了RunnableFuture接口, \n" +
//                    "\t\tRunnableFuture接口继承自Runnable接口和Future接口,\n" +
//                    "\t\t同时FutureTask类提供了传入一个Callable接口实现的构造器,\n" +
//                    "\t\t所以可以将Callable接口对象封装到FutureTask类的对像中,\n" +
//                    "\t\t然后再使用Thread类的构造器,通过传入FutureTask对象(Runnable接口对象), \n" +
//                    "\t\t最终实现使用Callable接口来创建线程对象\n" +
//                    "介绍完毕, call方法执行完毕, 返回call方法的执行结果"
//            );
//            return 666;
//        });

        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(
                        "call方法开始执行 ... \n" +
                                "下面开始介绍如何使用Callable接口来新建线程\n" +
                                "\t\tFutureTask类实现了RunnableFuture接口, \n" +
                                "\t\tRunnableFuture接口继承自Runnable接口和Future接口,\n" +
                                "\t\t同时FutureTask类提供了传入一个Callable接口实现的构造器,\n" +
                                "\t\t所以可以将Callable接口对象封装到FutureTask类的对像中,\n" +
                                "\t\t然后再使用Thread类的构造器,通过传入FutureTask对象(Runnable接口对象), \n" +
                                "\t\t最终实现使用Callable接口来创建线程对象\n" +
                                "介绍完毕, call方法执行完毕, 返回call方法的执行结果"
                );
                Thread.currentThread().sleep(10000);
                return 666;
            }
        });
        // 使用Callable接口创建线程
        Thread myThread = new Thread(ft, "test_thread");

        myThread.start();

        Thread.sleep(200);

        try {
            // 当test_thread线程执行一个耗时比较长的任务的时候,
            // 调用FutureTask对象的get方法获取call()方法返回值时,
            // main线程会等待test_thread线程执行完,
            // 也即ft.get()逻辑不出问题, 总能拿到call方法的返回值, 不会是空值
            Integer result = ft.get();
            System.out.println(" 拿到返回结果为:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
