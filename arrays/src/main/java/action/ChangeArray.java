/*Заменить каждый элемент с нечётным индексом на ноль*/
package action;

import model.CustomArray;
import org.apache.log4j.Logger;
import java.util.stream.IntStream;

public class ChangeArray {
    final static Logger logger = Logger.getLogger(ArithmeticAction.class);

    public void oddToZeroStream (CustomArray customArray) {
        logger.info("Change all odd elements to 0");
        customArray.setCustomArray(IntStream.of(customArray.getCustomArray())
                .map(value -> value = (( value % 2 != 0 ) ? 0 : value ))
                .toArray());
    }

    public void oddToZero (CustomArray customArray) {
        logger.info("Change all odd elements to 0");
        for (int i = 0; i < customArray.getSize(); i++) {
            if (customArray.get(i) % 2 != 0){
                customArray.getCustomArray()[i] = 0;
            }
        }
    }
}
