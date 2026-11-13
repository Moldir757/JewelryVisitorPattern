public class Earrings implements JewelryItem {
    private String name;
    private String material;
    private String style;
    private double price;

    public Earrings(String name, String material, String style, double price) {
        this.name = name;
        this.material = material;
        this.style = style;
        this.price = price;
    }

    public String getName() { return name; }
    public String getMaterial() { return material; }
    public String getStyle() { return style; }
    public double getPrice() { return price; }

    @Override
    public void accept(JewelryVisitor visitor) {
        visitor.visitEarrings(this);
    }
}
