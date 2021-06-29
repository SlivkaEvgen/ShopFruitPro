package SoftwareTestingJUnitMockito;

import lombok.Data;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Data
public class Fruit {
    private static double totalPrice;
    private int id;
    private String name;
    private double priceForOne;
    private double amount;
    private double promotionalAmount;
    private double promotionalPrice;
    private static Map<Integer, Fruit> allFruits;
    private static int countId = 0;

    public Fruit(String name, double priceForOne, double promotionalAmount, double promotionalPrice) {
        if (allFruits == null) {
            allFruits = new HashMap<>();
        }
        this.name = name;
        this.priceForOne = priceForOne;
        this.promotionalAmount = promotionalAmount;
        this.promotionalPrice = promotionalPrice;

        if (!hasFruit()) {
            countId++;
            this.id = countId;
            allFruits.put(id, this);
        }
    }

    private boolean hasFruit() {
        for (Fruit fruit : allFruits.values()) {
            if (fruit.equals(this) && fruit.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static double calculateTotalCost(String item) {
        item = item.toUpperCase(Locale.ROOT);
        String[] goods = item.split("");
        for (String good : goods) {
            for (int i = 1; i < allFruits.values().size() + 1; i++) {
                String aaa = allFruits.get(i).getName();
                if (aaa.equals(good)) {
                    allFruits.get(i).setAmount(allFruits.get(i).getAmount() + 1.0d);
                }
            }

        }
         totalPrice();
         return totalPrice;
    }

    private static void totalPrice() {

        for (int i = 1; i < allFruits.size()+1; i++) {

            double amount1 = allFruits.get(i).getAmount();
            double amountPro = allFruits.get(i).getPromotionalAmount();
            double pricePro = allFruits.get(i).getPromotionalPrice();
            double price1 = allFruits.get(i).getPriceForOne();
            double totalPrice1;
            if (amount1 < amountPro) {
                price1 = amount1 * price1;
                totalPrice1 = price1;
                totalPrice = totalPrice + totalPrice1;

            }
            if (amount1 >= amountPro) {
                int a = (int) (amount1 / amountPro);
                amount1 = amount1 - amountPro * a;
                pricePro = pricePro * a;
                totalPrice1 = price1 * amount1 + pricePro;
                totalPrice = totalPrice+totalPrice1;

            }
        }
    }
}
