import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 在java8中你可以使用   foreach + lambda表达式 或者 method reference(方法引用)
 */
public class ForEach {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("d");

        list.forEach(l -> System.out.println(l));
        list.forEach(l -> {
            if ("b".equals(l)) {
                System.out.println(l);
            }
        });

        Arrays.asList("a", "b", "d").forEach(s-> System.out.println(s));

       /* list.forEach(System.out::println);*/



    }
}
