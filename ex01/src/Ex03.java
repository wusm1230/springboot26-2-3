import java.util.Optional;

public class Ex03 {
    static void main() {
        System.out.println(Optional.of(getExamScore()));
    }

    private static int getExamScore(String subject) {
        if (subject.equals("수학"))
            return 100;
        else
            return 20;
    }

}
