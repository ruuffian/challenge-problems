package challenge.problems;

import challenges.misc.TargetSubset;
import org.junit.Assert;
import org.junit.Test;

public class TestTargetSubset {
    @Test
    public void TestAlgorithmSmall() {
        Assert.assertArrayEquals(new Long[]{2L, 3L}, new TargetSubset().recurse(new Long[]{2L, 3L, 4L}, 5).subset.toArray(Long[]::new));
    }

    @Test
    public void TestAlgorithmNoSolution() {
        Assert.assertArrayEquals(new Long[]{}, new TargetSubset().recurse(new Long[]{2L, 4L}, 5).subset.toArray(Long[]::new));
    }

    @Test
    public void TestInputParsing() {
        Assert.assertArrayEquals(new Long[]{2L, 3L, 4L}, TargetSubset.parseSet("2,3,4"));
    }
}
