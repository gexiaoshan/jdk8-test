/**
 * Created by gexiaoshan on 2018/6/3.
 */
public class InterfaceImpl implements Interface1,Interface2{


    @Override
    public void defaultMethod() {
        System.out.println("interfaceImpl default method.");
    }

    public static void main(String[] args) {
        Interface1.staticMethod();
        Interface2.staticMethod();
        new InterfaceImpl().defaultMethod();
    }
}
