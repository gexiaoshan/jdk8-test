/**
 * Java 8 新特性1
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）
 */
public class LambdaTest {
    public static void main(String[] args) {

        LambdaTest l = new LambdaTest();
        //函数式接口
        //类型申明
        MathOperation m1 = (int a,int b) -> a + b;
        //不用类型声明
        MathOperation m2 = (a , b) -> a - b;
        //大括号中的返回语句
        MathOperation m3 = (a , b) -> {return a*b; };
        System.out.println("a+b="  + l.operation(3,2, m1));
        System.out.println("a-b=" + l.operation(3, 2, m2));
        System.out.println("a*b=" + l.operation(3, 2, m3));

        GreetOperation g1 = message -> System.out.println("hello " + message);
        GreetOperation g2 = (message) -> System.out.println("hello " + message);
        g1.sayMessage("message11");
        g2.sayMessage("message22");
    }

    private int operation(int a,int b,MathOperation m){
        return m.operation(a,b);
    }

    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetOperation{
        void sayMessage(String message);
    }
}
