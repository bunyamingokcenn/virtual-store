public class Brand {
    private static int counter = 0;
    private final int id;
    private String name;

    public Brand(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


}
