package challenges.misc;


import org.junit.Assert;
import org.junit.Test;

public class TestTargetSubset {
    @Test
    public void testAlgorithmOutput() {
        Assert.assertArrayEquals(new Long[]{2L, 3L},
                new TargetSubset().recurse(new Long[]{2L, 3L, 4L}, 5).subset.toArray(Long[]::new));
        Assert.assertArrayEquals(new Long[]{},
                new TargetSubset().recurse(new Long[]{2L, 4L}, 5).subset.toArray(Long[]::new));
    }


    @Test
    public void testInputParsing() {
        Assert.assertArrayEquals(new Long[]{2L, 3L, 4L}, TargetSubset.parseSet("2,3,4"));
    }
}
