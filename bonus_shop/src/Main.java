import java.util.Scanner;

public class Main {

    public static String[] products = { "Хлеб", "Пачка гречки", "Упаковка яиц", "Мороженка" };
    public static int[] prices = { 50, 135, 65, 53 };
    public static int MIN_COST_FOR_BONUS = 1000;

    // В стоимости этих товаров каждые три товара должны стоить как два:
    public static String[] productsOnSale = { "Хлеб", "Мороженка" };

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин!");
        System.out.println("Наш ассортимент:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + products[i] + " за " + prices[i] + " за шт. ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int[] counts = new int[products.length];
        int sum = 0;


        while (true) {
            System.out.print("Введите номер товара и количество через пробел или end: ");
            String line = scanner.nextLine();
            int i;

            if ("end".equals(line)) {
                System.out.println("Ваша корзина покупок:");

                for (int j = 0; j < products.length; j++) {
                    if (counts[j] != 0) {
                        boolean isOnSale = false;
                        for (String saleProduct : productsOnSale) {
                            if (products[j].equals(saleProduct)) {
                                isOnSale = true;
                            }
                        }
                        if (isOnSale) {


                            sum += prices[j] * (counts[j] / 3 * 2 + counts[j] % 3);
                        } else {

                            sum += prices[j] * counts[j];
                        }

                        boolean doBonus = sum >= MIN_COST_FOR_BONUS;

                        for(i = 0; i < products.length; ++i) {
                            if (counts[i] != 0) {
                                String var10001 = products[i];
                                System.out.println("\t" + var10001 + " " + (doBonus ? counts[i] + 1 : counts[i]) + " шт. за " + (prices[j] * (counts[j] / 3 * 2 + counts[j] % 3)) + " руб.");
                            }
                        }
                    }
                }


                System.out.println("Итого: " + sum + " руб.");
                return;
            }

            String[] parts = line.split(" ");
            int productNum = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);

            counts[productNum] += productCount;
        }

    }

}
