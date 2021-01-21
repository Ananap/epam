package model;

public class CustomArray {
    private int[] customArray;

    public CustomArray(){}

    public CustomArray(int[] customArray){
        this.customArray = customArray;
    }

    public int get(int index) {
        if(index < 0 || index > getSize() - 1 ) {
            throw new IndexOutOfBoundsException();
        }
        return this.customArray[index];
    }

    public int getSize(){
        return customArray.length;
    }

    public void setCustomArray(int[] customArray) {
        this.customArray = customArray;
    }

    public int[] getCustomArray() {
        return customArray;
    }
}