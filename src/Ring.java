public class Ring implements JewelryItem {
    private String name;
    private String material;
    private String gemstone;
    private double price;

    public Ring(String name, String material, String gemstone, double price) {
        this.name = name;
        this.material = material;
        this.gemstone = gemstone;
        this.price = price;
    }

    public String getName() { return name; }
    public String getMaterial() { return material; }
    public String getGemstone() { return gemstone; }
    public double getPrice() { return price; }

    @Override
    public void accept(JewelryVisitor visitor) {
        visitor.visitRing(this);
    }
}
