import java.util.*;

public class Cart {
    int cartID;
    List<Product> itemsList;
    double subTotal;

    public Cart(int id) {
        cartID = id;
        itemsList = new ArrayList<>();
        subTotal = 0;
    }

    public void addItem(Product p) {
        if (p.isAvailable()) {
            itemsList.add(p);
            subTotal += p.price;
        }
    }

    public void removeItem(Product p) {
        if (itemsList.remove(p)) {
            subTotal -= p.price;
        }
    }

    public void showCart() {
        System.out.println("\n--- CART ---");
        for (Product p : itemsList) {
            System.out.println(p.name + " - " + p.price);
        }
        System.out.println("Subtotal: " + subTotal);
    }
}