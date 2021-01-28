package action;

import exception.ArrayException;
import model.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticActionTest {
    CustomArray array = new CustomArray(new int[] {1, 2, 3, 4, 5, 6, 7});
    ArithmeticAction arithmeticAction = new ArithmeticAction();

    @Test
    public void findMinTest() throws ArrayException {
        int min = arithmeticAction.searchMin(array);
        Assert.assertEquals(1, min);
    }

    @Test
    public void findMaxTest() throws ArrayException {
        int max = arithmeticAction.searchMaxStream(array);
        Assert.assertEquals(7, max);
    }

    @Test
    public void findAverageTest() throws ArrayException {
        double average = arithmeticAction.average(array);
        Assert.assertEquals((double)28/7, average);
    }

    @Test
    public void findSumTest() throws ArrayException {
        int sum = arithmeticAction.sumStream(array);
        Assert.assertEquals(28, sum);
    }
}
