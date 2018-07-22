package main.java.thread_plus.produ_consu;

/**
 * @description: 生产者消费者模型
 *
 *          线程的虚假唤醒(仅有一个生产者一个消费者,两个线程的场景下是不会出现线程的虚假唤醒的, 也即使用if也可以,但仅限于两个线程的情况下)
 *          资源自身暴露给线程调用的同步方法中的this.wait()方法的外层判断应该使用while而不是if
 *          因为while会将已经唤醒的线程重新进行判断,而if不会
 *          否则将会造成线程的虚假唤醒
 * @author: jxy
 * @create: 2018-07-22 15:43
 */
public class ThreadFakeNotify {

    public static void main(String[] args) {
        Demo_03_Resources resources = new Demo_03_Resources();

        Thread produ_01 = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者_01");

        Thread produ_02 = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者_02");


        Thread consu_01 = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者_01");

        Thread consu_02 = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者_02");


        produ_01.start();
        produ_02.start();
        consu_01.start();
        consu_02.start();

    }



}


class Demo_03_Resources{
    int i = 0;

    public synchronized void product() throws InterruptedException{
        while(i != 0){
            this.wait();
        }
        i++;
        System.out.println(Thread.currentThread().getName() + "生产了一个产品, " + i);
        this.notifyAll();
    }


    public synchronized void consume() throws InterruptedException{
        while(i == 0){
            this.wait();
        }
        i--;
        System.out.println(Thread.currentThread().getName() + "消费消费掉一个产品" + i);
        this.notifyAll();
    }

}