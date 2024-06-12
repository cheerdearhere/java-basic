package step05_designPatterns.builder;

public class UseStringBuilder {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        String result = s1
                .append("hi")
                .append(123)
                .append(true)
                .toString();
    }
}
