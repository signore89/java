public class Car {
    private int id;
    private String manufacturer;
    private String name;
    private double engine;
    private int year;
    private String color;
    private String type;

    public Car(int id, String manufacturer, String name, double engine,
               int year, String color, String type) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.name = name;
        this.engine = engine;
        this.year = year;
        this.color = color;
        this.type = type;
    }
    public int getId() { return id; }
    public String getManufacturer() { return manufacturer; }
    public String getName() { return name; }
    public double getEngine() { return engine; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s %s (%d) | %.1f л | %s | %s \n",
                manufacturer, name, year, engine, color, type);
    }
}
