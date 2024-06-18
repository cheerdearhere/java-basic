package step05_designPatterns.flyweight.after;

public final class Font {
    private final String family;
    private final int size;
    Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public String getFamily() {
        return family;
    }

    public int getSize() {
        return size;
    }
}
