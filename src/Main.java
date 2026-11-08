
import java.util.ArrayList;
import java.util.List;

interface JewelryItem {
    void accept(JewelryVisitor visitor);
}

interface JewelryVisitor {
    void visitRing(Ring ring);
    void visitNecklace(Necklace necklace);
    void visitEarrings(Earrings earrings);
}

class Ring implements JewelryItem {
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

class Necklace implements JewelryItem {
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

class Earrings implements JewelryItem {
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

class PriceReportVisitor implements JewelryVisitor {
    private double totalPrice = 0;

    @Override
    public void visitRing(Ring ring) {
        double finalPrice = ring.getPrice() * 1.10;
        totalPrice += finalPrice;
        System.out.printf("%s: %.2f KZT%n", ring.getName(), finalPrice);
    }

    @Override
    public void visitNecklace(Necklace necklace) {
        double finalPrice = necklace.getPrice() * 1.15;
        totalPrice += finalPrice;
        System.out.printf("%s: %.2f KZT%n", necklace.getName(), finalPrice);
    }

    @Override
    public void visitEarrings(Earrings earrings) {
        double finalPrice = earrings.getPrice() * 1.05;
        totalPrice += finalPrice;
        System.out.printf("%s: %.2f KZT%n", earrings.getName(), finalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class JewelryDescriptionVisitor implements JewelryVisitor {
    @Override
    public void visitRing(Ring ring) {
        System.out.println("Ring: " + ring.getName() +
                ", Material: " + ring.getMaterial() +
                ", Gemstone: " + ring.getGemstone() +
                ", Price: " + String.format("%.2f", ring.getPrice()) + " KZT");
    }

    @Override
    public void visitNecklace(Necklace necklace) {
        System.out.println("Necklace: " + necklace.getName() +
                ", Material: " + necklace.getMaterial() +
                ", Length: " + necklace.getLength() + " cm" +
                ", Price: " + String.format("%.2f", necklace.getPrice()) + " KZT");
    }

    @Override
    public void visitEarrings(Earrings earrings) {
        System.out.println("Earrings: " + earrings.getName() +
                ", Material: " + earrings.getMaterial() +
                ", Style: " + earrings.getStyle() +
                ", Price: " + String.format("%.2f", earrings.getPrice()) + " KZT");
    }
}

public class Main {
    public static void main(String[] args) {
        List<JewelryItem> jewelryCollection = new ArrayList<>();

        jewelryCollection.add(new Ring("Diamond Ring", "Gold", "Diamond", 150000));
        jewelryCollection.add(new Necklace("Gold Necklace", "Gold", 45, 200000));
        jewelryCollection.add(new Earrings("Pearl Earrings", "Silver", "Stud", 50000));

        PriceReportVisitor priceVisitor = new PriceReportVisitor();

        System.out.println("===== PRICE REPORT =====");

        for (JewelryItem item : jewelryCollection) {
            item.accept(priceVisitor);
        }

        System.out.printf("Total price: %.2f KZT%n", priceVisitor.getTotalPrice());

        JewelryDescriptionVisitor descriptionVisitor =
                new JewelryDescriptionVisitor();

        System.out.println("\n===== JEWELRY DESCRIPTIONS =====");

        for (JewelryItem item : jewelryCollection) {
            item.accept(descriptionVisitor);
        }
    }
}
