public class Product {
    private final String name;
    private final double price;
    private final Brand brand;
    private final int memory;
    private final int stock;
    private final int discountRate;
    //private String productType;

    public Product(String name, double price, Brand brand, int memory, int stock, int discountRate) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.memory = memory;
        this.stock = stock;
        this.discountRate = discountRate;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public Brand getBrand() {
        return brand;
    }


    public int getMemory() {
        return memory;
    }

    public int getStock() {
        return stock;
    }

    public int getDiscountRate() {
        return discountRate;
    }


}
