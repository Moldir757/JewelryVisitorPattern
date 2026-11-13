public class JewelryDescriptionVisitor implements JewelryVisitor {
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
