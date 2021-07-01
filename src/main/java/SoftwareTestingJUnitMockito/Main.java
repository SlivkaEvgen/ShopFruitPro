package SoftwareTestingJUnitMockito;

import Shop.Goods;
import lombok.Data;

@Data
public class Main {
    public static String coast = "ABCDABA";
    public static String coast1 = "BDCCCAAACCC";
    //public static String item = "ABCDABA";
   // public static String item = "РУСкие бу45вы";
    //public static String item = "CCCCCCCCCCCCCCCCCCCC";
    public static String item = "AAAAAACCCCCC";

    public static void main(String[] args) {
        new Goods("A", 1.25d, 3.00d, 3.00d);
        new Goods("B", 4.25d, 0.00d, 0.00d);
        new Goods("C", 1.00d, 5.00d, 6.00d);
        new Goods("D", 0.75d, 0.00d, 0.00d);

//        System.out.println(Fruit.calculateTotalCost(item));
//        System.out.println(Fruit.getAllFruits());
//        System.out.println(Fruit.getAllFruits("A"));
//        System.out.println(Fruit.getHowManyFruits());
//        System.out.println(Fruit.getHowManyFruits("A"));
//        System.out.println(Fruit.getTotalPriceForOne("A"));
        Goods.getOrder(item);
        System.out.println(Goods.allGoods);
        System.out.println(Goods.getTotalPriceForOne(1));
        System.out.println(Goods.allGoods.get(1).getAmount());
        System.out.println( Goods.allGoods.get(1).getPriceForOne() * Goods.allGoods.get(1).getAmount());
    }
}
