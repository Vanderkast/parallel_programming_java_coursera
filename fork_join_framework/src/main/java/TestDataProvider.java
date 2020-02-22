import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataProvider {
    static public List<Integer> getData() {
        return new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    }

    static public int getExpectedSum() {
        return 210;
    }
}
