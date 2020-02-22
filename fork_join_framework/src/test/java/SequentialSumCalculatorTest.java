import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SequentialSumCalculatorTest {
    private List<Integer> data;
    private SumCalculator calculator;

    @Before
    public void setUp() throws Exception {
        data = TestDataProvider.getData();
        calculator = new SequentialSumCalculator(data);
    }

    @Test
    public void calculate() {
        calculator.compute();
        assertNotNull(calculator.getResult());
        assertEquals(calculator.getResult(), Integer.valueOf(TestDataProvider.getExpectedSum()));
    }
}