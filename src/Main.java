import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserAuthService auth = new UserAuthService();
        auth.register("Case_Study", "D6");

        System.out.print("Username: ");
        String u = sc.next();

        System.out.print("Password: ");
        String p = sc.next();

        if (!auth.login(u, p)) {
            System.out.println("Login failed");
            return;
        }

        Customer customer = new Customer(1, u, "mail@gmail.com");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 70000));
        products.add(new Product(2, "Phone", "Electronics", 30000));
        products.add(new Product(3, "Shoes", "Fashion", 2000));
        products.add(new Product(4, "Watch", "Fashion", 5000));

        ProductFilterService pf = new ProductFilterService(products);
        Cart cart = new Cart(101);
        OrderService os = new OrderService();

        while (true) {
            System.out.println("\n1.View 2.Search 3.Filter 4.Add 5.Remove 6.Cart 7.Checkout 8.History 9.Exit");

            int ch = sc.nextInt();

            if (ch == 1) {
                for (Product pdt : pf.fetchItems()) {
                    System.out.println(pdt.getDetails());
                }
            }

            else if (ch == 2) {
                System.out.print("Search: ");
                String s = sc.next();
                for (Product pdt : pf.searchByName(s)) {
                    System.out.println(pdt.getDetails());
                }
            }

            else if (ch == 3) {
                System.out.print("Category: ");
                String c = sc.next();
                for (Product pdt : pf.applyCategoryFilter(c)) {
                    System.out.println(pdt.getDetails());
                }
            }

            else if (ch == 4) {
                System.out.print("Product ID: ");
                int id = sc.nextInt();
                for (Product pdt : products) {
                    if (pdt.productID == id) cart.addItem(pdt);
                }
            }

            else if (ch == 5) {
                System.out.print("Product ID: ");
                int id = sc.nextInt();
                for (Product pdt : products) {
                    if (pdt.productID == id) cart.removeItem(pdt);
                }
            }

            else if (ch == 6) {
                cart.showCart();
            }

            else if (ch == 7) {
                os.processCheckout(cart, customer);
            }

            else if (ch == 8) {
                customer.viewOrderHistory();
            }

            else if (ch == 9) {
                break;
            }
        }
    }
}
