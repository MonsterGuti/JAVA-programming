package SU3.WarehouseManagement;

public class Product {
    private String name;
    private int quantity;
    private int hazardLevel;

    public Product(String name, int quantity, int hazardLevel) {
        this.name = name;
        this.quantity = quantity;
        this.hazardLevel = hazardLevel;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getHazardLevel() { return hazardLevel; }
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setHazardLevel(int hazardLevel) {this.hazardLevel = hazardLevel; }

    @Override
    public String toString() {
        return String.format("%-15s | quantity: %-5d | danger: %d",
                name, quantity, hazardLevel);
    }
}

