/**
 * Created by gexiaoshan on 2018/6/3.
 */
public interface Interface1 {

    default void defaultMethod() {
        System.out.println("Interface1 default Method.");
    }

    static void staticMethod() {
        System.out.println("interface1 static Method.");
    }
}
