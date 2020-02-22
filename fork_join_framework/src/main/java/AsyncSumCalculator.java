import java.util.List;
import java.util.concurrent.RecursiveAction;

public class AsyncSumCalculator extends RecursiveAction implements SumCalculator {
    private final int SEQUENTIAL_THRESHOLD = 1000;
    private final List<Integer> data;
    private Integer result;

    public AsyncSumCalculator(List<Integer> data) {
        this.data = data;
        result = 0;
    }

    @Override
    public void compute() {
        long takenTime = System.nanoTime();
        if (data.size() < SEQUENTIAL_THRESHOLD) {
            data.forEach(t -> result += t);
        } else {
            AsyncSumCalculator left = new AsyncSumCalculator(data);
            AsyncSumCalculator right = new AsyncSumCalculator(data);
            left.fork();
            right.compute();
            left.join();
            result = left.getResult() + right.getResult();
        }
        takenTime = System.nanoTime() - takenTime;
        System.out.println("AsyncSumCalculator finished with taken time: " + takenTime);
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
