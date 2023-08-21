import java.util.ArrayList;
import java.util.List;



public class InvoiceCalculator {
    List<Product> mProducts = new ArrayList<>();

    public void addProduct(Product product) {
        mProducts.add(product);
        System.out.println("товар " + product.productName + " добавлен");
    }

    public double totalPrice() {
        double price = 0;
        for (Product person: mProducts) {
            price = price + person.price;
        }
        return price;
    }

    public void showList() {
        for (Product person: mProducts) {
            System.out.println(person.productName);
        }
    }

}
