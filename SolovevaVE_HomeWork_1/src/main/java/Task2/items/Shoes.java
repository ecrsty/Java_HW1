package Task2.items;

public class Shoes {
    private String type;
    private String brand;
    private int size;

    public Shoes(String type, String brand, int size) {
        this.type = type;
        this.brand = brand;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }
}
