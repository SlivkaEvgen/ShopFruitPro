package softwareTestingJUnitMockito;

import lombok.Data;

import java.util.*;

@Data
public class Goods {
    protected static String box;
    private String name;
    private int id;
    private static int countId = 0;
    private double priceForOne;
    private double stockPrice;
    protected static double totalPrice;
    private double stockAmount;
    private double amount;
    protected static Map<Integer, Goods> allGoods = new HashMap<>();

    Goods(String name, double priceForOne, double stockPrice, double stockAmount) {
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

    private static void getValidateName(String coast) {
        totalPrice = 0.00d;
        box = coast;
        box = box.toUpperCase();
    }

    private static void howMuch() {
        String[] items = box.split("");
        for (String item : items) {
            for (int j = 1; j < allGoods.values().size() + 1; j++) {
                if (allGoods.get(j).getName().equals(item)) {
                    allGoods.get(j).setAmount(allGoods.get(j).getAmount() + 1.00d);
                }
            }
        }
    }

    private static void getTotalPrice() {
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

    protected static void createNewCoasts() {
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
