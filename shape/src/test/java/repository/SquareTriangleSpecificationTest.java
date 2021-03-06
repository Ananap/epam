package repository;

import com.panasenko.shape.entity.CustomPoint;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.repository.impl.SquareTriangleSpecification;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareTriangleSpecificationTest {
    @Test
    public void SquareTriangleSpecificationTestPositive() {
        Triangle triangle = new Triangle(
                new CustomPoint(1, 5),
                new CustomPoint(1, 1),
                new CustomPoint(4, 1)
        );
        boolean result = new SquareTriangleSpecification(5, 7).specify(triangle);
        assertTrue(result);
    }

    @Test
    public void SquareTriangleSpecificationTestNegative() {
        Triangle triangle = new Triangle(
                new CustomPoint(1, 5),
                new CustomPoint(1, 1),
                new CustomPoint(4, 1)
        );
        boolean result = new SquareTriangleSpecification(7, 8).specify(triangle);
        assertFalse(result);
    }
}
