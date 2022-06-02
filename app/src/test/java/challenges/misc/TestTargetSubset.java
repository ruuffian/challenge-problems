package challenges.misc;

import org.junit.Assert;
import org.junit.Test;

public class TestTargetSubset {
    /**
     * Algorithm Testing
     */

    @Test
    public void testEmptyInput() {
        Assert.assertArrayEquals(new Long[]{},
                new TargetSubset().recurse(new Long[]{}, 0).subset.toArray(Long[]::new));
    }

    @Test
    public void testNoValidSolution() {
        Assert.assertArrayEquals(new Long[]{},
                new TargetSubset().recurse(new Long[]{3L, 5L}, 7).subset.toArray(Long[]::new));
    }

    @Test
    public void testInvalidTarget() {
        Assert.assertArrayEquals(new Long[]{},
                new TargetSubset().recurse(new Long[]{1L, 2L}, 0).subset.toArray(Long[]::new));
    }

    /* X_Y_Z indicates X target, Y elements in solution, Z elements in input*/
    @Test
    public void test5_2_3Solution() {
        Assert.assertArrayEquals(new Long[]{2L, 3L},
                new TargetSubset().recurse(new Long[]{2L, 3L, 4L}, 5).subset.toArray(Long[]::new));
    }

    @Test
    public void test5_2_2Solution() {
        Assert.assertArrayEquals(new Long[]{1L, 4L},
                new TargetSubset().recurse(new Long[]{1L, 4L}, 5).subset.toArray(Long[]::new));
    }

    @Test
    public void test24_4_3() {
        Assert.assertArrayEquals(new Long[]{3L, 7L, 7L, 7L},
                new TargetSubset().recurse(new Long[]{3L, 5L, 7L}, 24).subset.toArray(Long[]::new));
    }

    /**
     * Helper Method Testing
     */
    @Test
    public void test1Elements() {
        Assert.assertArrayEquals(new Long[]{2L}, TargetSubset.parseSet("2"));
    }

    @Test
    public void test2Elements() {
        Assert.assertArrayEquals(new Long[]{2L, 3L}, TargetSubset.parseSet("2,3"));
    }

    @Test
    public void test3Elements() {
        Assert.assertArrayEquals(new Long[]{2L, 3L, 4L}, TargetSubset.parseSet("2,3,4"));
    }
}
