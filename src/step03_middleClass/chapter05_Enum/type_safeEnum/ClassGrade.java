package step03_middleClass.chapter05_Enum.type_safeEnum;

public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    //private default constructor
    private ClassGrade() {}
}
