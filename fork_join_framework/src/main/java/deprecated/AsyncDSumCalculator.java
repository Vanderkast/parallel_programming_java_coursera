package deprecated;

import java.util.List;
import java.util.concurrent.ForkJoinTask;


public class AsyncDSumCalculator implements DSumCalculator {
    private DSumCalculatorImpl left;
    private DSumCalculatorImpl right;

    public AsyncDSumCalculator(List<Integer> data) {
        left = new DSumCalculatorImpl("left", data.subList(0, data.size() / 2));
        right = new DSumCalculatorImpl("right", data.subList(data.size() / 2, data.size()));
    }

    @Override
    public void compute() {
        ForkJoinTask.invokeAll(left, right);
    }

    @Override
    public Long getResult() {
        return left.getResult() + right.getResult();
    }
}
