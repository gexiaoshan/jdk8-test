/**
 * Created by gexiaoshan on 2018/6/3.
 */
public interface Interface2 {

    default void defaultMethod() {
        System.out.println(" interface2 default method.");
    }

    static void staticMethod() {
        System.out.println("interface2 static method.");
    }
}
