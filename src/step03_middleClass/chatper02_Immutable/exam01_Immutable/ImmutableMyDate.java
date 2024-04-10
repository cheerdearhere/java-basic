package step03_middleClass.chatper02_Immutable.exam01_Immutable;

public class ImmutableMyDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * reset Immutable MyDate's field
     * overloading method by three type
     * @param year change only year
     * @return ImmutableMyDate Object
     */
    public ImmutableMyDate resetDate(int year) {
        return new ImmutableMyDate(year, month, day);
    }
    /**
     * reset Immutable MyDate's field
     * overloading method by three type
     * @param year change year
     * @param month change month
     * @return ImmutableMyDate Object
     */
    public ImmutableMyDate resetDate(int year, int month) {
        return new ImmutableMyDate(year, month, day);
    }
    /**
     * reset Immutable MyDate's field
     * overloading method by three type
     * @param year change all data
     * @param month change all data
     * @param day change all data
     * @return ImmutableMyDate Object
     */
    public ImmutableMyDate resetDate(int year, int month, int day) {
        return new ImmutableMyDate(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
