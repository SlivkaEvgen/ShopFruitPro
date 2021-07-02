package softwareTestingJUnitMockito;

import lombok.Data;

@Data
public class Main {
    public static String coast = "ABCDABA"; //13.25
//    public static String coast1 = "BDCCCAAACCC";// 13.0
//    public static String item2 = "РУСкие бу45вы-A-B-C-D"; //7.25
//    public static String item4 = "РУСкие бу45выad";
//    public static String item3= "CCCCCCCCCCCCCCCCCCCC";
//    public static String item = "AAAAAAAAAAAAAAAAAAAA"; // 11.0

    public static void main(String[] args) {
        new Goods("A", 1.25d, 3.00d, 3.00d);
        new Goods("B", 4.25d, 0.00d, 0.00d);
        new Goods("C", 1.00d, 5.00d, 6.00d);
        new Goods("D", 0.75d, 0.00d, 0.00d);


//        System.out.println(Goods.calculateTotalCost(item));
//        System.out.println(Goods.calculateTotalCost(item3));
//        System.out.println(Goods.calculateTotalCost(item4));
        System.out.println(Goods.calculateTotalCost(coast));
//        System.out.println(Goods.calculateTotalCost(coast1));
//        System.out.println(Goods.allGoods.get(1));
    }
}
