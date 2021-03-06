package repository;

import com.panasenko.shape.entity.CustomPoint;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.repository.impl.PerimeterTriangleSpecification;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerimeterTriangleSpecificationTest {
    @Test
    public void PerimeterBetweenEllipseSpecificationPositiveTest() {
        Triangle triangle = new Triangle(
                new CustomPoint(1, 1),
                new CustomPoint(1, 5),
                new CustomPoint(4, 1)
        );
        boolean result = new PerimeterTriangleSpecification(11, 13).specify(triangle);
        assertTrue(result);
    }

    @Test
    public void PerimeterBetweenEllipseSpecificationNegativeTest() {
        Triangle triangle = new Triangle(
                new CustomPoint(1, 1),
                new CustomPoint(1, 5),
                new CustomPoint(4, 1)
        );
        boolean result = new PerimeterTriangleSpecification(13, 14).specify(triangle);
        assertFalse(result);
    }
}