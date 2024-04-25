package step03_middleClass.chapter05_Enum.refactoring;

public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(10);
    public static final ClassGrade GOLD = new ClassGrade(10);
    public static final ClassGrade DIAMOND = new ClassGrade(10);

    private final int discountPercent;

    //private default constructor
    private ClassGrade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
