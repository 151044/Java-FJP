package hk.ust.parallel.lab;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * A recursive task for counting numbers which have certain factors in a list.
 */
public class FactorCountTask extends RecursiveTask<Long> {
    /**
     * Threshold value. If the number of elements in the list fall below this level, it is not performant to split further.
     * The main way to tune this value would be experimentation.
     */
    private static final long THRESHOLD = 32;
    private final List<Long> toCount;
    private final List<Long> factors;

    /**
     * Constructs a new CountingTask.
     * @param toCount The list to find the element in
     * @param factors The list of factors to check
     */
    public FactorCountTask(List<Long> toCount, List<Long> factors) {
        this.toCount = toCount;
        this.factors = factors;
    }

    /**
     * Executes this task, counting the elements of the list which have all the factors given.
     * If the number of elements in the list is lower than the threshold, compute the occurrences directly.
     * Otherwise, split the tasks into two - construct two new FactorCountTasks and use their fork() methods
     * to submit them for execution.
     * Then, use join() to merge the results of the computation.
     * @return The number of elements found
     */
    @Override
    protected Long compute() {
        return 0L;
    }
}
