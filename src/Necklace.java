public class Necklace implements JewelryItem {
    private String name;
    private String material;
    private double length;
    private double price;

    public Necklace(String name, String material, double length, double price) {
        this.name = name;
        this.material = material;
        this.length = length;
        this.price = price;
    }

    public String getName() { return name; }
    public String getMaterial() { return material; }
    public double getLength() { return length; }
    public double getPrice() { return price; }

    @Override
    public void accept(JewelryVisitor visitor) {
        visitor.visitNecklace(this);
    }
}
