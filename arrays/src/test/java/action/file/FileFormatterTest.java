package action.file;

import exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileFormatterTest {

    @Test
    public void dataConverterTest () throws IOException, ArrayException {
        FileFormatter fileFormatter = new FileFormatter();
        ArrayList<String> list = fileFormatter.readFile("file.txt");
        List<String> resultList = Arrays.asList("1 2 3 4 5");
        Assert.assertEquals(resultList, list);
    }
}
