import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static org.junit.Assert.*;

public class AsyncSumCalculatorTest {
    private List<Integer> data;
    private SumCalculator calculator;

    @Before
    public void setUp() throws Exception {
        data = TestDataProvider.getData();
        calculator = new AsyncSumCalculator(data);
    }

    @Test
    public void calculate() {
        System.out.println("Just calculator.compute()");
        calculator.compute();
        assertNotNull(calculator.getResult());
        assertEquals(calculator.getResult(), Integer.valueOf(TestDataProvider.getExpectedSum()));
    }

    @Test
    public void calculate2() {
        System.out.println("Async with ForkJoinPool");
        ForkJoinPool.commonPool().invoke((RecursiveAction) calculator);
        assertNotNull(calculator.getResult());
        assertEquals(calculator.getResult(), Integer.valueOf(TestDataProvider.getExpectedSum()));
    }
}