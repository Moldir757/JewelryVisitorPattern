import java.util.ArrayList;
import java.util.List;

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
