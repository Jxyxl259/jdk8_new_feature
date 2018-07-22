package main.java.thread_plus.produ_consu;

/**
 * @description: 线程的通信, 实现交替打印 使用传统synchronized关键字
 *
 *          两个线程, 一个打印1~52 另一个打印 A~Z
 *          打印顺序为12A34B56C...5152Z
 * @author: jxy
 * @create: 2018-07-22 15:54
 */
public class ThreadCommunicateAlternatePrint {

    public static void main(String[] args) {

        Resources resources = new Resources();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 26; i++){
                try {
                    resources.printNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread_number");

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 26; i++) {
                try {
                    resources.printAlph();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread_alph");

        t1.start();
        t2.start();
    }

}

class Resources {

    private int num = 1;
    private char aChar = 'A';
    private int loop = 1;


    public synchronized void printNum() throws InterruptedException{

        if(loop <= 78){
            if(loop % 3 == 0){
                this.wait();
            }
            System.out.print((num++)+ "" + (num++));
            loop+=2;
            this.notify();
        }
    }

    public synchronized void printAlph()  throws InterruptedException{


        if(loop <= 78){
            if(loop % 3 != 0){
                this.wait();
            }
            System.out.print(new String(new char[]{aChar++}));
            loop+=1;
            this.notify();
        }

    }

}