package SoftwareTestingJUnitMockito;

import lombok.Data;

@Data
public class Main {
    public static String coast = "ABCDABA";
    public static String coast1 = "BDCCCAAACCC";
    //public static String item = "ABCDABA";
    public static String item = "  A   D";

    public static void main(String[] args) {
        new Fruit("A", 1.25d, 3.00d, 3.00d);
        new Fruit("B", 4.25d, 0.00d, 0.00d);
        new Fruit("C", 1.00d, 6.00d, 5.00d);
        new Fruit("D", 0.75d, 0.00d, 0.00d);

        System.out.println(Fruit.calculateTotalCost(item));
    }
}
