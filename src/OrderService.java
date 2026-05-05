public class OrderService {
    int transactionID = 1;

    public Order processCheckout(Cart cart, Customer customer) {
        Order o = new Order(transactionID++, customer.customerID, cart.itemsList);
        o.generateBillPDF();
        saveToHistory(customer, o);
        return o;
    }

    public void saveToHistory(Customer c, Order o) {
        c.addOrder(o);
    }
}