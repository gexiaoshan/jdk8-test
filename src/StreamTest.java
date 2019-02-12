import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gexiaoshan on 2018/6/14.
 */
public class StreamTest {

    public static void main(String[] args) {

        //1.map()--可以将对象转换为其他对象
        //1.1
        List<String> m1 = Arrays.asList("as", "adf", "DD");
        List<String> m2 = m1.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println("m2：" + m2);

        //1.2
        List<String> m3 = m1.stream().map(x -> x.concat("-hello")).collect(Collectors.toList());
        System.out.println("m3:" + m3);

        //1.3
        List<Person> p1 = Arrays.asList(new Person("1", 1, "p1", 2),
                new Person("2", 2, "p2", 2));
        List<Person> p2 = p1.stream().map(x -> new Person(x, "par")).collect(Collectors.toList());
        p2.forEach(p -> {
            System.out.println(p.toString());
        });

        //2.flatMap()
        //看列子 只可意会不可言传
        List<String[]> l1 = m1.stream().map(x -> x.split("")).collect(Collectors.toList());
        List<String> l2 = l1.stream().flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);

        //3.filter 过滤
        List f1 = m1.stream().filter(x -> x.contains("a")).collect(Collectors.toList());
        System.out.println(f1);

        //4.findFirst 返回 Stream 的第一个元素
        String ff1 = m1.stream().findFirst().orElse("nothing");
        System.out.println(ff1);
        System.out.println("--------");

        //5.把 reduce 元素组合起来
        //5.1 未定义初始值，从而第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素
        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("--------");
        //5.2 定义了初始值，从而第一次执行的时候第一个参数的值是初始值，第二个参数是Stream的第一个元素
        int accResult2 = Stream.of(1, 2, 3, 4)
                .reduce(1, (acc, item) -> {
                    System.out.println("acc : "  + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult2);
        System.out.println("--------");

        String r1 = Stream.of("a", "b", "c").reduce("", String::concat);

        System.out.println("r1:" + r1);


//        List<String> strings = Arrays.asList("12", "23", "43", "", "32", "");
//        System.out.println(strings);
//        long count = strings.stream().filter(string -> string.isEmpty()).count();
//        List<String> ss = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        System.out.println(ss);
//        String s = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
//        System.out.println(s);
//
//        List<Integer> ints = Arrays.asList(2, 5, 3, 1, 1);
//        List seq = ints.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        System.out.println(seq);
//
//        IntSummaryStatistics stas = ints.stream().mapToInt(x -> x).summaryStatistics();
//        System.out.println(stas.getAverage());
//        System.out.println(stas.getMax());
//        System.out.println(ints.stream().mapToInt(x -> x).sum());
//        System.out.println(ints.stream().mapToInt(x -> x).reduce(0, (x, y) -> x + y));
//
//
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);
//
//        Person p1 = new Person("1", 3, "1", 1);
//        Person p2 = new Person("2", 0, "0", 2);
//        Person p3 = new Person("3", 3, "0", 1);
//        Person p4 = new Person("4", 2, "1", 2);
//        List<Person> Persons = Arrays.asList(p1, p2, p3, p4);
//        Integer sum = Persons.stream().filter(x -> "0".equals(x.getType())).mapToInt(Person::getAge).sum();
//        Integer sum2 = Persons.stream().mapToInt(x -> x.getAge() * x.getNum()).sum();
//        Integer sum3 = Persons.stream().mapToInt(x -> x.getAge()).min().getAsInt();
//
//        long count2 = Persons.stream().filter(x -> (x.getAge() - x.getNum() >= 0)).count();
//        System.out.println(sum);
//        System.out.println(sum2);
//        System.out.println("sum3:" + sum3);
//        System.out.printf("count2:" + count2);

    }


    static class Person {
        private String id;
        private Integer age;
        private String type;
        private Integer num;

        public Person() {
        }

        public Person(String id, Integer age, String type, Integer num) {
            this.id = id;
            this.age = age;
            this.type = type;
            this.num = num;
        }

        public Person(Person p, String par) {
            this.id = p.getId();
            this.age = p.getAge();
            this.type = par;
            this.num = p.getNum();
        }

        public Integer getAge() {
            return age;
        }

        public Integer getNum() {
            return num;
        }

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public String toString() {
            return this.id + "," + this.getAge() + "," + this.getType() + "," + this.getNum();
        }
    }
}
