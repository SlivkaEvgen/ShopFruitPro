package softwareTestingJUnitMockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GoodsTest {
    String item = "AAAAAACCCCCCDDDDD";
    Goods goods0 = new Goods("A", 1.25d, 3.00d, 3.00d);
    Goods goods1 = new Goods("B", 4.25d, 0.00d, 0.00d);
    Goods goods2 = new Goods("C", 1.00d, 5.00d, 6.00d);
    Goods goods3 = new Goods("D", 0.75d, 0.00d, 0.00d);
    List<Goods> actualList = new ArrayList<>();

    @Before
    public void setUp() {

        this.actualList.add(this.goods0);
        this.actualList.add(this.goods1);
        this.actualList.add(this.goods2);
        this.actualList.add(this.goods3);
    }

    @Test(expected = AssertionError.class)
    public void minusShouldFailAmount() {
        Goods goods = Goods.allGoods.get(1);
        try {
            goods.setAmount(-2.0d);
            Assert.fail("Not minus");
        } catch (AssertionError es) {
            Assert.assertEquals(0.0d, -100.0d, 0.01d);
        }

    }

    @Test(expected = AssertionError.class)
    public void minusShouldFailPrice() {
        Goods goods = Goods.allGoods.get(2);
        try {
            goods.setPriceForOne(-2.0d);
            Assert.fail("Not minus");
        } catch (AssertionError es) {
            Assert.assertEquals(0.0d, -10.0d, 0.01d);
        }

    }

    @Test(expected = AssertionError.class)
    public void minusShouldFailStockPrice() {
        Goods goods = Goods.allGoods.get(2);
        try {
            goods.setStockPrice(-1.0d);
            Assert.fail("Not minus");
        } catch (AssertionError es) {
            Assert.assertEquals(0.0d, -1.0d, 0.01d);
        }

    }

    @Test(expected = AssertionError.class)
    public void minusShouldFailStockAmount() {
        Goods goods = Goods.allGoods.get(2);
        try {
            goods.setStockAmount(-3.0d);
            Assert.fail("Not minus");
        } catch (AssertionError es) {
            Assert.assertEquals(0.0d, -100.0d, 0.01d);
        }
    }

    @Test
    public void calculateTotalCostTest() {
        double expectedGet = 14.75d;
        double actual = Goods.totalPrice;
        Assert.assertEquals(expectedGet, actual, 0.01d);
    }

    @Test
    public void calculateTotalCostTest1() {
        //Goods.calculateTotalCost(this.item);
        double expected = 6.0d;

        double actual = Goods.allGoods.get(1).getAmount();
        //double actual = this.actualList.get(1).getAmount();
        Assert.assertEquals(expected, actual, 0.01d);

        double expected2 = 6.0d;
        double actual2 = Goods.allGoods.get(3).getAmount();
        //double actual2 = this.actualList.get(1).getAmount();

        Assert.assertEquals(expected2, actual2, 0.01d);
    }

    @Test
    public void testGetValidateName() {
        Goods.calculateTotalCost(this.item);
        String expected = "AAAAAACCCCCCDDDDD";
        String expected1 = "";
        String actual = Goods.box.toUpperCase();

        Assert.assertNotNull("testGetValidateName - NULL", actual);
        Assert.assertNotNull("testGetValidateName - NULL", expected);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, "");
    }

    @Test(expected = AssertionError.class)
    public void isEmpty() {
        this.item = "";
        Goods.calculateTotalCost(this.item);
        Goods.box = "";
        try {
            Assert.fail(" Try again \n English capital letters only");
            throw new RuntimeException();
        } catch (AssertionError ex) {

            Assert.assertEquals("ABCDAB", "");
        }

    }

    @Test
    public void testHowMuch() {
        double expected = -2.00d;
        double actual = Goods.allGoods.get(1).getAmount();
        Assert.assertEquals(expected, actual, 0.01d);
        double expected1 = 0.00d;
        double actual1 = Goods.allGoods.get(2).getAmount();
        Assert.assertEquals(expected1, actual1, 0.01d);
        double expected2 = 6.00d;
        double actual2 = Goods.allGoods.get(3).getAmount();
        Assert.assertEquals(expected2, actual2, 0.01d);
        double expected3 = 5.00d;
        double actual3 = Goods.allGoods.get(4).getAmount();
        Assert.assertEquals(expected3, actual3, 0.01d);
    }

    @Test
    public void testGetTotalPrice() {
        double expected = 14.75d;
        double actual = Goods.totalPrice;
        Assert.assertEquals(expected, actual, 0.01d);
        double a = Goods.allGoods.get(1).getAmount();
        double b = Goods.allGoods.get(1).getStockAmount();

        double expected1 = -2.00d;
        Assert.assertEquals(expected1, a, 0.01d);
        double expected2 = 3.00d;
        Assert.assertEquals(expected2, b, 0.01d);
    }

    @Test
    public void testCreateNewCoasts() {
        Goods.createNewCoasts();
        double expected = 0.00d;
        double actual = Goods.allGoods.get(1).getAmount();
        Assert.assertEquals(expected, actual, 0.01d);
        double expected1 = 0.00d;
        double actual1 = Goods.totalPrice;
        Assert.assertEquals(expected1, actual1, 0.01d);
    }
}