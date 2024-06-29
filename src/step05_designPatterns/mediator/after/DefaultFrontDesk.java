package step05_designPatterns.mediator.after;

import step03_middleClass.chapter05_Enum.test.exam02.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class DefaultFrontDesk implements HwaHanSystem, FrontDesk{
    private final CleaningService<HwaHanSystem> cleaningService = new CleaningService<>(this);
    private final Restaurant restaurant = new Restaurant(this);
    private final List<Customer> guests = new ArrayList<>();

    @Override
    public Customer checkIn(String guestName, Long guestId, Integer roomNumber) {
        Customer guest = new Guest(guestId,roomNumber,guestName);
        guests.add(guest);
        return guest;
    }
    @Override
    public void checkOut(Customer guest) {
        if(!guests.contains(guest)) {
            throw new RuntimeException(HttpStatus.NOT_FOUND.name());
        }
        Integer roomNumber = guest.getRoomNumber();
        System.out.println(roomNumber +"번 방 체크아웃을 진행합니다.");
        guests.remove(guest);
        cleaningService.clean(roomNumber,true);
    }
    @Override
    public void bookingRestaurant(Customer guest, List<RestaurantMenu> menus) {
        restaurant.reservation(guest.getId(),menus);
    }
    @Override
    public void getTowers(Customer guest, int numberOfTowers){
        cleaningService.getTower(guest.getId(), numberOfTowers);
    }
    @Override
    public void dinner(Customer guest, boolean isRoomCharge){
        restaurant.dinner(guest.getId(), isRoomCharge);
    }
    @Override
    public void dinnerCancel(Customer guest){
        restaurant.cancelReservation(guest.getId());
    }
    @Override
    public void roomCharged(Long guestId, int totalPrice){
        Customer guest = getGuestById(guestId);
        if(!guests.contains(guest)){
            throw new RuntimeException(HttpStatus.NOT_FOUND.name());
        }else{
            System.out.println(guest.getRoomNumber()+"번 방에 "+totalPrice+"원 결재 예약");
        }
    }
    @Override
    public Integer getRoomNumberById(Long guestId) {
        return getGuestById(guestId).getRoomNumber();
    }
    @Override
    public String getGuestNameById(Long guestId){
        return getGuestById(guestId).getName();
    }

    private Customer getGuestById(Long guestId){
        return guests.stream()
                .filter(g->g.getId()==guestId).findFirst()
                .orElseThrow(()-> new  RuntimeException(HttpStatus.NOT_FOUND.name()));
    }
}
