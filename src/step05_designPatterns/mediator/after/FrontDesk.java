package step05_designPatterns.mediator.after;

import step03_middleClass.chapter05_Enum.test.exam02.HttpStatus;

import java.util.List;

public interface FrontDesk {
    Integer getRoomNumberById(Long guestId);
    String getGuestNameById(Long guestId);

    Customer checkIn(String guestName, Long guestId, Integer roomNumber) ;
    void checkOut(Customer guest);

    void getTowers(Customer guest, int numberOfTowers);
    void roomCharged(Long guestId, int totalPrice);

    void bookingRestaurant(Customer guest, List<RestaurantMenu> menus);
    void dinner(Customer guest, boolean isRoomCharge);
    void dinnerCancel(Customer guest);



}
