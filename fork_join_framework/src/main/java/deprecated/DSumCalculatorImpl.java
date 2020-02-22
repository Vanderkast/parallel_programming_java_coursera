package deprecated;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class DSumCalculatorImpl extends RecursiveAction implements DSumCalculator {
    private String name;
    private List<Integer> list;
    private Long result;

    public DSumCalculatorImpl(String name, List<Integer> list) {
        this.name = name;
        this.list = list;
        result = 0L;
    }

    @Override
    public void compute() {
        list.forEach(element -> {
            System.out.println(name + ": "+ element);
            result += element;
        });
    }

    public Long getResult() {
        return result;
    }
}
