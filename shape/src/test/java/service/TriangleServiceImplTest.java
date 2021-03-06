package service;

import com.panasenko.shape.entity.CustomPoint;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.service.impl.TriangleServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class TriangleServiceImplTest {
    TriangleServiceImpl service;

    @BeforeClass
    public void setUp() {
        service = new TriangleServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        service = null;
    }

    @Test
    public void calculatePerimeterTest() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(1, 5);
        CustomPoint thirdPoint = new CustomPoint(4, 1);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        double expected = 12;
        double actual = service.calculatePerimeter(triangle);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void calculateSquareTest() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(1, 5);
        CustomPoint thirdPoint = new CustomPoint(4, 1);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        double expected = 6;
        double actual = service.calculateSquare(triangle);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void isTriangleTestNegative() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(1, 5);
        CustomPoint thirdPoint = new CustomPoint(1, 2);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        boolean result = service.isTriangle(triangle);
        assertFalse(result);
    }

    @Test
    public void isTriangleIsoscelesTest() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(1, 3);
        CustomPoint thirdPoint = new CustomPoint(3, 1);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        boolean result = service.isTriangleIsosceles(triangle);
        assertTrue(result);
    }

    @Test
    public void isTriangleRightTest() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(1, 3);
        CustomPoint thirdPoint = new CustomPoint(3, 1);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        boolean result = service.isTriangleRight(triangle);
        assertTrue(result);
    }

    @Test
    public void isTriangleAcuteTest() {
        CustomPoint firstPoint = new CustomPoint(1, 1);
        CustomPoint secondPoint = new CustomPoint(5, 2);
        CustomPoint thirdPoint = new CustomPoint(5, 1);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        boolean result = service.isTriangleRight(triangle);
        assertTrue(result);
    }
}
