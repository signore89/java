import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReverseList {
    public static <T> List<T> reverseList(List<T> originalList) {
        List<T> reversed = new ArrayList<>(originalList);

        Collections.reverse(reversed);

        return reversed;
    }
}
