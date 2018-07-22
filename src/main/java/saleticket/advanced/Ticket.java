package main.java.saleticket.advanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用JUC包下的Lock接口代替synchronized关键字, 实现三个窗口卖票的资源类
 * @author: jxy
 * @create: 2018-07-21 23:23
 */
public class Ticket {

    private int number = 30;

    /** JUC包下可以替代synchronized关键字的锁 */
    private Lock lock = new ReentrantLock();

    /**
     *  资源类提供操纵自身资源的方法, 暴露给线程调用
     */
    public void saleTicket(){
        lock.lock();
        try {
            if(number > 0){
                System.out.print(Thread.currentThread().getName() + "卖出第" + (30 - number + 1) + "张票\t");
                number --;
                System.out.println("余票 : " + number + "张");
            }else{
                System.out.println("票已售尽...");
            }
        } finally {
            lock.unlock();
        }
    }
}
