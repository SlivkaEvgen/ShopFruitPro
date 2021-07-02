package softwareTestingJUnitMockito;

import lombok.Data;

import java.util.*;

@Data
public class Goods {
    static String box;
    public String name;
    int id;
    private static int countId = 0;
    double priceForOne;
    double stockPrice;
    static double totalPrice;
    double stockAmount;
    double amount;
    public static Map<Integer, Goods> allGoods = new HashMap<>();

    public Goods(String name, double priceForOne, double stockPrice, double stockAmount) {
        this.name = name;
        this.priceForOne = priceForOne;
        this.stockPrice = stockPrice;
        this.stockAmount = stockAmount;

        if (this.name != null) {
            countId++;
            this.id = countId;
            allGoods.put(this.id, this);
        }
    }

    public static void getValidateName(String coast) {
        totalPrice = 0.00d;
        box = coast;
        box = box.toUpperCase();
    }

    public static void howMuch() {
        String[] items = box.split("");
        for (String item : items) {
            for (int j = 1; j < allGoods.values().size() + 1; j++) {
                if (allGoods.get(j).getName().equals(item)) {
                    allGoods.get(j).setAmount(allGoods.get(j).getAmount() + 1.00d);
                }
            }
        }
    }

    public static void getTotalPrice() {
        for (int i = 1; i < allGoods.size() + 1; i++) {
            double amount1 = allGoods.get(i).getAmount();
            double amountPro = allGoods.get(i).getStockAmount();
            double pricePro = allGoods.get(i).getStockPrice();
            double price1 = allGoods.get(i).getPriceForOne();
            if (amount1 < amountPro) {
                totalPrice = totalPrice + (amount1 * price1);
            }
            if (amount1 >= amountPro) {
                int a = (int) (amount1 / amountPro);
                totalPrice = totalPrice + ((price1 * (amount1 - (amountPro * a))) + (pricePro * a));
            }
        }
    }

    public static void createNewCoasts() {
        for (int i = 1; i < allGoods.values().size() + 1; i++) {
            allGoods.get(i).setAmount(0.00d);
            totalPrice = 0.00d;
        }
    }

    public static double calculateTotalCost(String coast) {
        createNewCoasts();
        getValidateName(coast);
        howMuch();
        getTotalPrice();
        return totalPrice;
    }
}
