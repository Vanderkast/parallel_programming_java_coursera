import java.util.List;

public class SequentialSumCalculator implements SumCalculator {
    private final List<Integer> data;
    private Integer result;
    private Long takenTime;

    public SequentialSumCalculator(List<Integer> data) {
        this.data = data;
        result = 0;
    }

    @Override
    public void compute() {
        takenTime = System.nanoTime();
        data.forEach(t -> result += t);
        takenTime = System.nanoTime() - takenTime;
        System.out.println("SequentialSumCalculator finished with taken time: " + takenTime);
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
