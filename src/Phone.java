public class Phone extends PersonalDevice{
    private static int counter = 0;
    private final int ID;
    private final int cameraResolution;
    private final String color;

    public Phone(String name, double price, Brand brandName, int memory, String screenSize , int cameraResolution, int batteryPower, int ram, String color, int discountRate, int stock) {
        super(name, price, brandName, memory, stock, discountRate, screenSize, ram, batteryPower);
        this.ID = ++counter;
        this.cameraResolution = cameraResolution;
        this.color = color;
    }


    public int getID() {
        return ID;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }


    public String getColor() {
        return color;
    }

}
