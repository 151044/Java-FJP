package hk.ust.parallel.lab;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class CountingTaskTest {
    private static final long FIRST_LONG = 6942030624700L;
    private static final List<Long> FIRST_FACTORS = List.of(2L, 5L, 53L, 29581L, 44279L);
    private static final long SECOND_LONG = 199390346834118558L;
    private static final List<Long> SECOND_FACTORS = List.of(2L, 3L, 19L, 29L, 53L,
            83L, 101L, 103L, 107L, 109L, 113L);
    private static final long PAD_SIZE = 10000000L;

    private static final List<Long> target = new ArrayList<>();
    private static final List<Long> toAdd = List.of(FIRST_LONG, FIRST_LONG, FIRST_LONG,
            FIRST_LONG, SECOND_LONG, SECOND_LONG);
    @BeforeAll
    static void init() {
        target.addAll(toAdd);
        target.addAll(LongStream.range(2, PAD_SIZE + 2).boxed().toList());
        Collections.shuffle(target);
    }
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void firstLongTest() {
        ForkJoinPool pool = new ForkJoinPool();
        FactorCountTask task = new FactorCountTask(target, FIRST_FACTORS);
        pool.execute(task);
        assertEquals(4, task.join());
    }
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void secondLongTest() {
        ForkJoinPool pool = new ForkJoinPool();
        FactorCountTask task = new FactorCountTask(target, SECOND_FACTORS);
        pool.execute(task);
        assertEquals(2, task.join());
    }

    /**
     * This should be slower than your fork/join implementation by a factor of 2-3.
     */
    @Test
    void directIterator() {
        long ans = 0;
        for (Long l : target) {
            if (SECOND_FACTORS.stream().allMatch(f -> l % f == 0)) {
                ans++;
            }
        }
        assertEquals(2, ans);
    }
}