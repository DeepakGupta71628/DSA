import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    static void main() {
        String s="Deepak";

        s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()<2).findFirst().orElse(null);

    }
}
