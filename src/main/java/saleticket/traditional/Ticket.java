package main.java.saleticket.traditional;

/**
 * @description: 三个售票窗口卖票 的资源类, 使用synchronized关键字,实现同步锁
 * @author: jxy
 * @create: 2018-07-21 22:11
 */
public class Ticket {

    private int number = 30;

    public synchronized void saleTicket(){
        if(number > 0){
            // System.out.print(Thread.currentThread().getName() + "卖出第" + (number--) + "张票\t");
            System.out.print(Thread.currentThread().getName() + "卖出第" + (30 - number + 1) + "张票\t");
            number --;
            System.out.println("余票 : " + number + "张");
        }else{
            System.out.println("票已售尽...");
        }
    }

}
