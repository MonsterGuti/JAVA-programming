package SU3.WarehouseManagement;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private final List<Product> products =  new ArrayList<>();
    public void storeProduct(Product p) throws OverstockException, HazardousMaterialException{
        if (p.getQuantity() > 1000)
            throw new OverstockException("Too large quantity! (max 1000)");
        if (p.getHazardLevel() > 7)
            throw new HazardousMaterialException("Hazardous product! (level above 7)");
        products.add(p);
    }
    public List <Product> getProducts() {
        return products;
    }
    public boolean isEmpty() {
        return products.isEmpty();
    }
}
