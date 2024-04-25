package step03_middleClass.chapter05_Enum.refactoring;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30), VIP(40);

    private final int discountPercent;

    Grade (int discountPercent) {
        this.discountPercent = discountPercent;
    }
    public int getDiscountPercent() {
        return discountPercent;
    }
    public int getDiscountPrice(int price){
        return price * discountPercent / 100;
    }
}
