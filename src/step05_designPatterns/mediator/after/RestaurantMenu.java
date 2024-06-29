package step05_designPatterns.mediator.after;

public enum RestaurantMenu{
    TOMATO_PASTA(10_000,"토마토 파스타"),
    CARBONARA(13_000,"까르보나라"),
    MUSHROOM_CREAM_SPAGHETTI(13_000,"버섯 크림 파스타"),
    SIRIOIN_STEAK(32_000, "채끝 등심 스테이크"),
    RIB_EYE_STEAK(32_000,"꽃등심 스테이크"),
    CAESAR_SALAD(13_000,"샐러드")
    ;
    final int price;
    final String name;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    RestaurantMenu(int price, String name) {
        this.price = price;
        this.name = name;
    }
}