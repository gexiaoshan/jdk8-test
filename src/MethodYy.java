import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Java 8 新特性2
 * 方法引用
 */
public class MethodYy {
    public static void main(String[] args) {

        List<Persion> l = new ArrayList<Persion>();
        Supplier<Persion> s = () -> new Persion("test");
        PersionFactory f = new PersionFactory(s);
        //方法引用::引用构造函数
        PersionFactory f2 = new PersionFactory(Persion::new);

        Persion p = f.getPersion();
        Persion p2 = f2.getPersion();

        System.out.println(p.getName());
        System.out.println(p2.getName());

        p2.setName("dff");
        Persion p3 = f2.getPersion();
        p3.setName("asd");
        Persion p4 = f2.getPersion();
        p4.setName("bdf");
        l.add(p2);
        l.add(p3);
        l.add(p4);

        Persion[] ps = l.toArray(new Persion[l.size()]);
        System.out.println("排序前:");
        for (Persion pp : ps) {
            System.out.println(pp.getName());
        }

        //方法引用::引用静态方法
        Arrays.sort(ps, MethodYy::compare);
        System.out.println("排序后：");
        for (Persion pp : ps) {
            System.out.println(pp.getName());
        }

        Persion[] ps2 = l.toArray(new Persion[l.size()]);
        System.out.println("排序前：");
        for (Persion pp : ps2) {
            System.out.println(pp.getName());
        }
        //方法引用::引用特定对象的实例方法
        Arrays.sort(ps2, p2::compare);
        System.out.println("排序后：");
        for (Persion pp : ps2) {
            System.out.println(pp.getName());
        }

        Persion[] ps3 = l.toArray(new Persion[l.size()]);
        System.out.println("排序前：");
        for (Persion pp : ps3) {
            System.out.println(pp.getName());
        }
        Arrays.sort(ps3,Persion::compareTo);
        System.out.println("排序后：");
        for (Persion pp : ps3) {
            System.out.println(pp.getName());
        }

    }

    public static int compare(Persion p1, Persion p2) {
        return p1.getName().compareTo(p2.getName());
    }

    static class Persion {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Persion() {
        }

        public Persion(String name) {
            this.name = name;
        }

        public int compare(Persion p1, Persion p2) {
            return p1.getName().compareTo(p2.getName());
        }

        public int compareTo(Persion p) {
            return this.getName().compareTo(p.getName());
        }

    }

    static class PersionFactory {

        private Supplier<Persion> supplier;

        public PersionFactory(Supplier<Persion> supplier) {
            this.supplier = supplier;
        }

        public Persion getPersion() {
            return supplier.get();
        }
    }
}
