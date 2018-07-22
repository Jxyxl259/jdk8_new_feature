package main.java.thread_plus.produ_consu;

/**
 * @description: 线程通信, 生产者消费者 模型 使用传统synchronized关键字
 *
 *          生产者消费者模型, 实现对一个初始值为0的变量,
 *          两个线程, 一个线程对其进行+1(生产) 另一个线程对其进行-1(消费)
 * @author: jxy
 * @create: 2018-07-22 19:05
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        Demo_02_Resources resources = new Demo_02_Resources();

        Thread produ = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者");


        Thread consu = new Thread(() -> {
            for(int i = 0; i<10 ; i++){
                try {
                    resources.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者");

        produ.start();
        consu.start();
    }
}


class Demo_02_Resources{
    int i = 0;

    public synchronized void product() throws InterruptedException{
        if(i != 0){
            this.wait();
        }
        i++;
        System.out.println(Thread.currentThread().getName() + "生产了一个产品, " + i);
        this.notifyAll();
    }


    public synchronized void consume() throws InterruptedException{
        if(i == 0){
            this.wait();
        }
        i--;
        System.out.println(Thread.currentThread().getName() + "消费消费掉一个产品" + i);
        this.notifyAll();
    }

}