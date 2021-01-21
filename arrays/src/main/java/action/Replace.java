/*Заменить каждый элемент с нечётным индексом на ноль*/
package action;

import model.Array;

public class Replace {

    public Array replace (Array array) {
        for (int i = 0; i < array.getMyArray().length; i++) {
            if(i % 2 == 1) {
                array.getMyArray()[i] = 0;
            }
        }
        return array;
    }
}
