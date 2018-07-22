package main.java.lambda.functional_inc;

@FunctionalInterface
public interface MyFoo {

    /**
     *  接口传统方式的使用, 仅声明方法的定义, 方法的具体实现由子类去实现
     * @param name
     */
    public void print(String name);


    /**
     * 可以定义多个default关键字修饰的带有方法实现的方法
     */
    default int add(int x, int y){
        return x + y;
    }

    /**
     * 可以定义多个default关键字修饰的带有方法实现的方法
     */
    default int div(int x, int y){
        return x / y;
    }


    /**
     * 接口中静态方法的调用
     * @return
     */
    public static String introduce(){
        return "hello 0316";
    }
}
