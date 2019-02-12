import java.util.Optional;

/**
 * Created by gexiaoshan on 2018/6/3.
 * 使用Optional避免null导致的NullPointerException
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable("123");
        System.out.println(fullName.isPresent());
        System.out.println(fullName.orElseGet(()->"none"));
        System.out.println(fullName.map(s -> "Hey " + s + "!" ).orElse("Hey Stranger!"));
    }
}
