import action.ChangeArray;
import action.SortArray;
import model.CustomArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        ChangeArray changeArray = new ChangeArray();
        CustomArray unsortedArray = new CustomArray(new int[] {1, 2, 3, 4, 5});
        int[] resultArray = new int[]{1, 0, 3, 0, 5};
        changeArray.oddToZero(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray.getCustomArray()));
    }
}
