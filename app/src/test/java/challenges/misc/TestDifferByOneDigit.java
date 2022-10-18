package challenges.misc;

import org.junit.Assert;
import org.junit.Test;

public class TestDifferByOneDigit {
    @Test
    public void testOneDigitArrays() {
        Assert.assertEquals(1,  new DifferByOneDigit().solution(new int[]{1,9}));
        Assert.assertEquals(0, new DifferByOneDigit().solution(new int[]{1,1}));
        Assert.assertEquals(3, new DifferByOneDigit().solution(new int[]{1,9,3}));
        Assert.assertEquals(6, new DifferByOneDigit().solution(new int[]{1,9,4,5}));
    }

    @Test
    public void testTwoDigitArrays() {
        Assert.assertEquals(1, new DifferByOneDigit().solution(new int[]{10,12}));
        Assert.assertEquals(0, new DifferByOneDigit().solution(new int[]{22,11}));
        Assert.assertEquals(3, new DifferByOneDigit().solution(new int[]{99,89,59}));
        Assert.assertEquals(3, new DifferByOneDigit().solution(new int[]{22,21,13,12}));
    }

    @Test
    public void testNDigitArrays() {
        Assert.assertEquals(3, new DifferByOneDigit().solution(new int[]{1,9,32,11,932}));
        Assert.assertEquals(0, new DifferByOneDigit().solution(new int[]{1,20,310,}));
        Assert.assertEquals(2, new DifferByOneDigit().solution(new int[]{1,111,11}));
    }
}
