package hk.ust.parallel.lab;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTaskTest {
    private static final long LEN_TEST = 1000000L;
    private static final List<Long> target = LongStream.range(0, LEN_TEST).boxed().collect(Collectors.toList());
    @BeforeAll
    static void setup() {
        Collections.shuffle(target);
    }
    @Test
    void sort() {
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(target);
        pool.execute(task);
        assertEquals(LongStream.range(0, LEN_TEST).boxed().collect(Collectors.toList()), task.join());
    }
}