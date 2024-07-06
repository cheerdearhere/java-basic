package step05_designPatterns.mediator.after;

import java.util.List;

public class Hotel {
    public static void main(String[] args) {
        FrontDesk defaultFrontDesk = new DefaultFrontDesk();
        Guest guestHong = (Guest) defaultFrontDesk.checkIn("hong",1L, 501);
        defaultFrontDesk.getTowers(guestHong,3);
        defaultFrontDesk.bookingRestaurant(
                guestHong,
                List.of(
                        RestaurantMenu.CARBONARA,
                        RestaurantMenu.TOMATO_PASTA,
                        RestaurantMenu.CAESAR_SALAD,
                        RestaurantMenu.RIB_EYE_STEAK
                )
        );
        defaultFrontDesk.dinner(guestHong, true);
        defaultFrontDesk.bookingRestaurant(
                guestHong,
                List.of(RestaurantMenu.CAESAR_SALAD, RestaurantMenu.RIB_EYE_STEAK)
        );
        defaultFrontDesk.dinnerCancel(guestHong);
        defaultFrontDesk.checkOut(guestHong);
    }
}
