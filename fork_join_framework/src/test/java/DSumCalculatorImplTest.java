import deprecated.DSumCalculator;
import deprecated.DSumCalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DSumCalculatorImplTest {
    private List<Integer> data;
    private Long expiredResult;

    private DSumCalculator DSumCalculator;

    @Before
    public void setUp() throws Exception {
        data = TestDataProvider.getData();
        expiredResult = (long) TestDataProvider.getExpectedSum();
        DSumCalculator = new DSumCalculatorImpl("test", data);
    }

    @Test
    public void compute() {
        DSumCalculator.compute();
        assertEquals(expiredResult, DSumCalculator.getResult());
    }
}