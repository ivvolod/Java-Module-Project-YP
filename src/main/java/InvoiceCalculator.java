import java.util.ArrayList;
import java.util.List;


public class InvoiceCalculator {
    private final List<Product> mProducts = new ArrayList<>();

    public void addProduct(Product product) {
        mProducts.add(product);
    }

    public double totalPrice() {
        double price = 0;
        for (Product person : mProducts) {
            price = price + person.price;
        }
        return price;
    }

    public void showList() {
        System.out.println("Добавленные товары:");
        for (Product person : mProducts) {
            String format = String.format("%s - %.2f", person.productName, person.price);
            System.out.println(format);
        }
    }

}
