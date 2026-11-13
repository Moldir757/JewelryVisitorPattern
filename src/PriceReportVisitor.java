public class PriceReportVisitor implements JewelryVisitor {
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
