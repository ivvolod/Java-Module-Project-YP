import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPerson = enterNumberFriends(scanner);
        InvoiceCalculator invoiceCalculator = new InvoiceCalculator();
        billEntry(scanner,invoiceCalculator);
        invoiceCalculator.showList();
        formatTotalPrice(invoiceCalculator, numberPerson);

        scanner.close();

    }
    public static int enterNumberFriends(Scanner scanner){
        System.out.print("На сколько друзей разделить счёт: ");
        while (true) {
            if (scanner.hasNextInt()) {
                int numberPeople = scanner.nextInt();
                if (numberPeople <= 1) {
                    System.out.println("Введите корректное значение");
                } else if (numberPeople > 1){
                    return numberPeople;
                }
            }else {
                System.out.print("Введите целое число");
            }
        }
    }

    public static void billEntry(Scanner scanner, InvoiceCalculator invoiceCalculator) {
        while (true) {
            String productName = scanner.nextLine();
            double price;
            System.out.print("Введите наименование товара: ");
            while (true) {
                if (scanner.hasNextLine()) {
                    productName = scanner.nextLine();
                    break;
                }else System.out.println("Вы ошиблись, введите наименование товара еще раз");
            }
            System.out.print("Введите стоимость товара: ");
            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    break;
                }else System.out.println("Вы ошиблись, введите стоимость товара еще раз");
            }
            invoiceCalculator.addProduct(new Product(productName, price));
            System.out.println("Товар добавлен. Хотите продолжить - введите любой не пробельный символ, иначе - \"Завершить\"");
            if (scanner.next().equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    public static void formatTotalPrice(InvoiceCalculator invoiceCalculator, int numberPerson) {
        int roundWhole = (int)Math.floor(invoiceCalculator.totalPrice()/numberPerson);
        int lastDigit = roundWhole % 10;
        String formatRuble = "рубль";

        switch (lastDigit) {
            case 1:
                formatRuble = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                formatRuble = "рубля";
                break;
            default:
                formatRuble = "рублей";
                break;
        }
        String format = String.format("Итого каждому к оплате: %.2f %s", invoiceCalculator.totalPrice()/numberPerson, formatRuble);
        System.out.println(format);

    }

}