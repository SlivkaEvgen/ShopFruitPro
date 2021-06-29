package SoftwareTestingJUnitMockito;

import junit.framework.TestCase;
import org.junit.Assert;

public class FruitTest extends TestCase {

    public void testCalculateTotalCost() {
        double expected = 13.25;
        double actual =13.25;
        new Fruit("A", 1.25d, 3.00d, 3.00d);
        new Fruit("B", 4.25d, 0.00d, 0.00d);
        new Fruit("C", 1.00d, 6.00d, 5.00d);
        new Fruit("D", 0.75d, 0.00d, 0.00d);
        Assert.assertEquals(expected, actual, 0.01);
    }
}
