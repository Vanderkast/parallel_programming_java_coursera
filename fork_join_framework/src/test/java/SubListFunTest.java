import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SubListFunTest {
    public List<Integer> parent;

    @Before
    public void setUp() {
        parent = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void clearingParent() {
        List<Integer> sub = parent.subList(0, parent.size() / 2);
        parent.clear();
        try {
            Integer i = sub.get(0);
            assertEquals(Integer.valueOf(0), i);
        } catch (Exception e) {
            e.printStackTrace();
            assert e instanceof ConcurrentModificationException;
        }
    }

    @Test
    public void removingParentElement() {
        List<Integer> sub = parent.subList(0, parent.size() / 2);
        parent.remove(3);
        try {
            StringBuilder message = new StringBuilder();
            sub.forEach(message.append(" ")::append);
            System.out.println(message);
            assert sub.size() == 4;
        } catch (Exception e) {
            e.printStackTrace();
            assert e instanceof ConcurrentModificationException;
        }
    }
}
