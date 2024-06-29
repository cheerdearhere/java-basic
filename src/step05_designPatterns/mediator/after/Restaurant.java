package step05_designPatterns.mediator.after;


import step03_middleClass.chapter05_Enum.test.exam02.HttpStatus;

import java.util.*;

public class Restaurant implements HwaHanSystem{
    private String name;
    private final Map<Long, List<RestaurantMenu>> bookList = new LinkedHashMap<>();

    private final DefaultFrontDesk defaultFrontDesk;
    public Restaurant(DefaultFrontDesk defaultFrontDesk) {
        this.defaultFrontDesk = defaultFrontDesk;
    }

    public void reservation(long guestId, List<RestaurantMenu> menus){
        if(bookList.containsKey(guestId)){
            System.out.println(name + " 고객님은 이미 예약하신 내역이 있습니다.");
        }
        if(bookList.size()==30){
            System.out.println();
        }
        bookList.put(guestId, menus);
    }
    public void cancelReservation(long guestId){
        if(!bookList.containsKey(guestId)){
            System.out.println("예약 내역이 없습니다.");
        }else {
            System.out.println("dinner: "+ defaultFrontDesk.getGuestNameById(guestId)+"님의 예약이 취소됩니다");
            bookList.remove(guestId);
        }
    }
    public void dinner(Long guestId, boolean isRoomCharge){
        if(!bookList.containsKey(guestId)){
            System.out.println("예약 내역이 없습니다.");
        }else {
            System.out.println("dinner: "+ defaultFrontDesk.getGuestNameById(guestId)+"님의 식사가 진행됩니다.");
            List<RestaurantMenu> menuList = bookList.get(guestId);
            System.out.println("식사 중: "+menuList);
            if(isRoomCharge){
                roomCharge(guestId);
            }else{
                System.out.println(guestId+"번 고객님 현장결재 완료: "+menuList.stream().mapToInt(RestaurantMenu::getPrice).sum());
            }
            bookList.remove(guestId);
        }
    }
    public void roomCharge(Long guestId){
        List<RestaurantMenu> menuList = bookList.get(guestId);
        if(menuList==null){
            throw new RuntimeException(HttpStatus.BAD_REQUEST.name());
        }
        defaultFrontDesk.roomCharged(
                guestId,
                menuList.stream().mapToInt(RestaurantMenu::getPrice).sum()
        );
    }
}
