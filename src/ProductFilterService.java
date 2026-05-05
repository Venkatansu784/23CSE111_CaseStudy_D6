import java.util.*;

public class ProductFilterService {
    List<Product> allProducts;

    public ProductFilterService(List<Product> products) {
        allProducts = products;
    }

    public List<Product> fetchItems() {
        return allProducts;
    }

    public List<Product> applyCategoryFilter(String category) {
        List<Product> res = new ArrayList<>();
        for (Product p : allProducts) {
            if (p.category.equalsIgnoreCase(category)) {
                res.add(p);
            }
        }
        return res;
    }

    public List<Product> searchByName(String name) {
        List<Product> res = new ArrayList<>();
        for (Product p : allProducts) {
            if (p.name.toLowerCase().contains(name.toLowerCase())) {
                res.add(p);
            }
        }
        return res;
    }
}