package Shop;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Data
public class Goods {
    public String name;
    int id;
    double priceForOne;
    static double totalPriceForOne;
    double stockPrice;
    double stockAmount;
    double amount;
    double totalPriceStock;
    private static int countId = 0;
    public static Map<Integer, Goods> allGoods = new HashMap<>();


    public Goods(String name, double priceForOne, double stockPrice, double stockAmount) {
        this.name = name;
        this.priceForOne = priceForOne;
        this.stockPrice = stockPrice;
        this.stockAmount = stockAmount;

        if (!hasGoods()) {
            countId++;
            this.id = countId;
            allGoods.put(id, this);
        }
    }

    private boolean hasGoods() {
        for (Goods goods : allGoods.values()) {
            if (goods.equals(this) && goods.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static String getOrder(String basket) {
        if (basket.matches("[a-zA-Z]+")) {
            basket = basket.toUpperCase(Locale.ROOT);
            String[] items = basket.split("");
            for (String item : items) {
                for (int i = 1; i < allGoods.values().size() + 1; i++) {
                    String name = allGoods.get(i).getName();
                    if (name.equals(item)) {
                        allGoods.get(i).setAmount(allGoods.get(i).getAmount() + 1.0d);
                    }
                }
            }
        } else {
            System.out.println("Please, try again");
           basket="";
        }
        return basket;
    }
    public static double getTotalPriceForOne(int id) {
        double a = allGoods.get(id).getPriceForOne();
        double b = allGoods.get(id).getAmount();
        totalPriceForOne = a*b; //allGoods.get(id).getPriceForOne() * allGoods.get(id).getAmount();
        return totalPriceForOne;
    }

}
