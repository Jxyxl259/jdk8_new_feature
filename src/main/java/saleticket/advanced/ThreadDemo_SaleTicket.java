package main.java.saleticket.advanced;

/**
 * @description: 卖票主程序
 * @author: jxy
 * @create: 2018-07-21 22:49
 */
public class ThreadDemo_SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        Thread t1 = new Thread(() -> {
            for(int i = 0 ; i < 10 ; i ++){
                ticket.saleTicket();
            }
        }, "窗口1");
        Thread t2 = new Thread(() -> {
            for(int i = 0 ; i < 10 ; i ++){
                ticket.saleTicket();
            }
        }, "窗口2");
        Thread t3 = new Thread(() -> {
            for(int i = 0 ; i < 10 ; i ++){
                ticket.saleTicket();
            }
        }, "窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
