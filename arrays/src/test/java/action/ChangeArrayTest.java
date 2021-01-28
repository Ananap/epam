package action;

import model.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeArrayTest {
    ChangeArray changeArray = new ChangeArray();

    @Test
    public void oddToZeroStreamTest (){
        CustomArray unsortedArray = new CustomArray(new int[] {1, 2, 3, 4, 5});
        int[] resultArray = new int[]{0, 2, 0, 4, 0};
        changeArray.oddToZeroStream(unsortedArray);
        Assert.assertEquals(resultArray, unsortedArray.getCustomArray());
    }

    @Test
    public void oddToZeroTest (){
        CustomArray unsortedArray = new CustomArray(new int[] {1, 2, 3, 4, 5});
        int[] resultArray = new int[]{0, 2, 0, 4, 0};
        changeArray.oddToZero(unsortedArray);
        Assert.assertEquals(resultArray, unsortedArray.getCustomArray());
    }
}
