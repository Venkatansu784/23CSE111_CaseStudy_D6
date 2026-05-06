import java.io.*;

public class OrderService {

    int transactionID = 1;

    public Order processCheckout(Cart cart, Customer customer) {

        Order o = new Order(transactionID++, customer.customerID, cart.itemsList);

        o.generateBill();

        saveToHistory(customer, o);

        return o;
    }

    public void saveToHistory(Customer c, Order o) {

        c.addOrder(o);

        try {

            FileWriter writer = new FileWriter("order_history.txt", true);

            writer.write("----- NEW ORDER -----\n");

            writer.write("Order ID: " + o.orderID + "\n");

            for (Product p : o.items) {
                writer.write(p.getDetails() + "\n");
            }

            writer.write("----------------------\n\n");

            writer.close();

            System.out.println("Order saved to file.");

        }

        catch (Exception e) {

            System.out.println("Error saving order.");

        }
    }
}
