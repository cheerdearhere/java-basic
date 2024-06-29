package step05_designPatterns.mediator.before;

public class Hotel {
    public static void main(String[] args) {
        Guest guest = new Guest("hong");
        guest.getTower(3);
        guest.dinner();

        Restaurant restaurant = new Restaurant("hong3SuperRestaurant");
        restaurant.clean();
    }
}
