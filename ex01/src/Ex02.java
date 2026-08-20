import java.util.Optional;

public class Ex02 {
    static void main() {
        Optional<String> qq = Optional.of("Hello");
        System.out.println(qq.get());

        System.out.println(Optional.ofNullable(null).orElse("기본값"));
    }
}
