package Shop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GoodsTest {
    String item;
    String item1;

    @Before
    public void setUp() {
        List<Goods> actualList = new ArrayList<>();

        Goods goods1 = new Goods("A", 1.25d, 3.00d, 3.00d);
        Goods goods2 = new Goods("B", 4.25d, 0.00d, 0.00d);
        Goods goods3 = new Goods("C", 1.00d, 5.00d, 6.00d);
        Goods goods4 = new Goods("D", 0.75d, 0.00d, 0.00d);
        actualList.add(goods1);
        actualList.add(goods2);
        actualList.add(goods3);
        actualList.add(goods4);

    }

    @Test
    public void testGetOrder() {
        item = "AAAAAACCCCCC";
        item1 = "";
        String expectedGet = Goods.getOrder(item);
        String actual = item;
        Assert.assertEquals(expectedGet, actual);
    }
    @Test
    public void testGetOrder1() {
//        List<Goods> expected =  Goods.allGoods.values().stream().toList();
//
//        List<Goods> actualList = new ArrayList<>();
//
//        actualList.add(new Goods("A", 1.25d, 3.00d, 3.00d));
//        actualList.add(new Goods("B", 4.25d, 0.00d, 0.00d));
//        actualList.add(new Goods("C", 1.00d, 5.00d, 6.00d));
//        actualList.add(new Goods("D", 0.75d, 0.00d, 0.00d));
//
//        Assert.assertEquals(expected, actualList);


    }

    @Test
    public void testGetOrder2() {
        double expected5 = Goods.allGoods.get(1).getAmount();
        double actual5 = 6.0;
        Assert.assertEquals(expected5, actual5, 0.0);

        double expected4 = Goods.allGoods.get(3).getAmount();
        double actual4 = 6.0;
        Assert.assertEquals(expected4, actual4, 0.0);
    }

    @Test
    public void testGetTotalPriceForOne() {
        double expected = Goods.getTotalPriceForOne(1);
        double actual = 7.5;
        Assert.assertEquals(expected, actual, 0.0);

    }
}