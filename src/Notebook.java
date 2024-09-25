public class Notebook extends PersonalDevice{
    private static int counter = 0;
    private final int ID;
    private final String storageType;

    public Notebook(String name, double price, Brand brandName, int memory, String screenSize, int ram, int stock, int discountRate, int batteryPower, String storageType) {
        super(name, price, brandName, memory, stock, discountRate, screenSize, ram, batteryPower);
        this.ID = ++counter;
        this.storageType = storageType;
    }

    public int getID() {
        return ID;
    }

    public String getStorageType() {
        return storageType;
    }

}
