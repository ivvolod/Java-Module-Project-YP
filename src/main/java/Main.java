import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек необходимо разделить счёт:");
        int numberPerson = checkingNumberGuests(scanner);
        InvoiceCalculator invoiceCalculator = new InvoiceCalculator();
        invoiceCalculator.addProduct (new Product("первый", 10.20));
        invoiceCalculator.addProduct (new Product("второй", 20.21));
        invoiceCalculator.addProduct (new Product("третий", 30.23));
        invoiceCalculator.addProduct (new Product("четвертый", 40.24));
        invoiceCalculator.addProduct (new Product("пятый", 50.22));

        System.out.println(invoiceCalculator.totalPrice());
        invoiceCalculator.showList();

    }
    public static int checkingNumberGuests(Scanner scanner){
        while (true) {
            if (scanner.hasNextInt()) {
                int numberPeople = scanner.nextInt();
                if (numberPeople <= 1) {
                    System.out.println("Введите корректное значение");
                } else if (numberPeople > 1){
                    return numberPeople;
                }
            }else {
                System.out.println("Введите целое число");
            }

        }

    }

}