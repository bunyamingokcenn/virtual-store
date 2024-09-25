public class PersonalDevice extends Product{
    private String screenSize;
    private final int ram;
    private final int batteryPower;

    public PersonalDevice(String name, double price, Brand brandName, int memory, int stock, int discountRate, String screenSize, int ram, int batteryPower) {
        super(name, price, brandName, memory, stock, discountRate);
        this.screenSize = screenSize;
        this.ram = ram;
        this.batteryPower = batteryPower;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }


    public int getBatteryPower() {
        return batteryPower;
    }

}
