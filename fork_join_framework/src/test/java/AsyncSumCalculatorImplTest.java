import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AsyncSumCalculatorImplTest {
    private ArrayList<Integer> data;
    private Long expiredResult;

    private SumCalculator sumCalculator;

    @Before
    public void setUp() throws Exception {
        data = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        expiredResult = 45L;
        sumCalculator = new AsyncSumCalculator(data);
    }

    @Test
    public void calculate() {
        sumCalculator.compute();
        assertEquals(expiredResult, sumCalculator.getResult());
    }
}