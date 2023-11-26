package hk.ust.parallel.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Implements merge sorting using fork/join pools.
 */
public class MergeSortTask extends RecursiveTask<List<Long>> {
    /**
     * Threshold value. If the number of elements in the list fall below this level, it is not performant to split further.
     * The main way to tune this value would be experimentation.
     */
    private static final long THRESHOLD = 32;
    private final List<Long> toSort;

    /**
     * Creates a new MergeSortTask.
     * @param toSort The list to sort
     */
    public MergeSortTask(List<Long> toSort) {
        this.toSort = toSort;
    }

    /**
     * Executes this task, returning a new sorted list.
     * If the number of elements in the list is lower than the threshold, sort the list directly with Collections.sort().
     * Otherwise, split the tasks into two - construct two new MergeSortTasks and use their fork() methods
     * to submit them for execution.
     * Then, use join() and merge() to merge the results of the computation.
     * Remember to construct new lists instead of returning a
     * subList() to prevent modifying the original list.
     * @return The number of elements found
     */
    @Override
    protected List<Long> compute() {
        return List.of();
    }

    /**
     * Merges the two given lists in ascending order.
     * @param l1 The first list to merge
     * @param l2 The second list to merge
     * @return A list containing all elements from both lists, sorted in ascending order
     */
    private List<Long> merge(List<Long> l1, List<Long> l2) {
        return List.of();
    }
}
