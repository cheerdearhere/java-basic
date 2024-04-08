package step03_middleClass.chapter01_Object.objectClass03_equals;

public class EqualsMainV1 {
    public static void main(String[] args) {
        UserV1 userV1 = new UserV1("id-100");
        UserV1 userV2 = new UserV1("id-100");

        boolean identity = userV1 == userV2;
        boolean equals = userV1.equals(userV2);

        System.out.println("identity = " + identity);
        System.out.println("equals = " + equals);

    }
}
