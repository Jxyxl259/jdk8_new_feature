package main.java.lambda.functional_inc;

/**
 * @description: 函数式接口Demo
 * @author: jxy
 * @create: 2018-07-22 11:57
 */
public class FunctionalInterface_Demo {

    public static void main(String[] args) {

        // 如果接口中没有定义public abstract方法,则只需要一个空实现而已
        // e.g : MyFoo myfoo = new MyFoo(){};
        MyFoo myfoo = new MyFoo() {
            @Override
            public void print(String name) {
                System.out.println("hello" + name);
            }
        };

        myfoo.print("jiangBUG");

        int addResult = myfoo.add(2, 2);

        System.out.println(addResult);

        System.out.println(MyFoo.introduce());
    }

}
