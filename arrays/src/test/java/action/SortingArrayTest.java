package action;

import model.CustomArray;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortingArrayTest {
    private CustomArray customArray;
    private SortArray sortArray;

    @BeforeMethod
    public void setUp() {
        customArray = new CustomArray();
        customArray.setCustomArray(new int[]{0, -20, 3, 2, 9, -10, -45, 34});
        sortArray = new SortArray();
    }

    @AfterMethod
    public void tearDown() {
        customArray = null;
        sortArray = null;
    }
    @Test
    public void testBubbleSortCustomArray(){
        int[] expectedArray = {-45, -20, -10, 0, 2, 3, 9, 34};
        sortArray.bubbleSort(customArray);
        int[] actualArray = customArray.getCustomArray();
        assertEquals(actualArray, expectedArray);
    }
    @Test
    public void testChoiseSortCustomArray(){
        int[] expectedArray = {-45, -20, -10, 0, 2, 3, 9, 34};
        sortArray.choiceSort(customArray);
        int[] actualArray = customArray.getCustomArray();
        assertEquals(actualArray,expectedArray);
    }
    @Test
    public void testInsertionSortCustomArray(){
        int[] expectedArray = {-45, -20, -10, 0, 2, 3, 9, 34};
        sortArray.insertionSort(customArray);
        int[] actualArray = customArray.getCustomArray();
        assertEquals(actualArray,expectedArray);
    }
}
