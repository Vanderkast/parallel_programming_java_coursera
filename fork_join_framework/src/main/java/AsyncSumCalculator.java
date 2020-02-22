import java.util.List;
import java.util.concurrent.ForkJoinTask;


public class AsyncSumCalculator implements SumCalculator{
    private SumCalculatorImpl left;
    private SumCalculatorImpl right;

    public AsyncSumCalculator(List<Integer> data) {
        left = new SumCalculatorImpl("left", data.subList(0, data.size() / 2));
        right = new SumCalculatorImpl("right", data.subList(data.size() / 2, data.size()));
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
