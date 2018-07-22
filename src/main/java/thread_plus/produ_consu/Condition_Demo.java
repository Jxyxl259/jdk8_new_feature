package main.java.thread_plus.produ_consu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用Condition接口实现按序抢
 * @author: jxy
 * @create: 2018-07-23 00:27
 */
public class Condition_Demo {

    public static void main(String[] args) {
        Condition_Demo_Resources resources = new Condition_Demo_Resources();

        Thread consu_01 = new Thread(() -> {
            for(int i = 0; i<10; i++){
                resources.consume();
            }
        },"c_1");
        Thread consu_02 = new Thread(() -> {
            for(int i = 0; i<10; i++){
                resources.consume();
            }
        },"c_2");
        Thread produ_01 = new Thread(() -> {
            for(int i = 0; i<10; i++){
                resources.produce();
            }
        },"p_1");
        Thread produ_02 = new Thread(() -> {
            for(int i = 0; i<10; i++){
                resources.produce();
            }
        }, "p_2");

        produ_01.start();
        produ_02.start();
        consu_01.start();
        consu_02.start();
    }

}


class Condition_Demo_Resources{
    private int i = 0;

    private Lock lock = new ReentrantLock();

    private Condition cond = lock.newCondition();

    public void consume(){
        lock.lock();
        try {
            while (i == 0) {
                cond.await();
            }
            i--;
            System.out.println(Thread.currentThread().getName() + "\t" + i);
            cond.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void produce(){
        lock.lock();
        try {
            while (i != 0) {
                cond.await();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "\t" + i);
            cond.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

}