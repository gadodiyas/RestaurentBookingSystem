import model.Restaurant;
import model.enums.RestaurantType;
import model.enums.SearchFields;
import service.BookingSystemManager;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        BookingSystemManager bookingSystemManager = new BookingSystemManager();
        Restaurant restaurant1 = Restaurant.getBuilder()
                .setName("ABC")
                .setCityName("Bangalore")
                .setAreaName("HSR")
                .setCostForTow(Double.valueOf(200))
                .setMaxFutureDays(5)
                .setRestaurantType(RestaurantType.VEG)
                .setCuisineList(Arrays.asList("North-Indian", "South-Indian", "Asian"))
                .build();

        Restaurant restaurant2 = Restaurant.getBuilder()
                .setName("XYZ")
                .setCityName("Bangalore")
                .setAreaName("Kormangala")
                .setCostForTow(Double.valueOf(400))
                .setMaxFutureDays(5)
                .setRestaurantType(RestaurantType.VEG)
                .setCuisineList(Arrays.asList("North-Indian", "South-Indian"))
                .build();

        restaurant1 = bookingSystemManager.registerRestaurant(restaurant1);
        restaurant2 = bookingSystemManager.registerRestaurant(restaurant2);
        //assuming every slot is of 1hr and each table can accomodate n persons
        Map<LocalDateTime, Integer> availabilityMap = new HashMap<>();
        availabilityMap.put(LocalDateTime.of(2023, Month.MARCH, 12, 10, 00), 5);
        availabilityMap.put(LocalDateTime.of(2023, Month.MARCH, 12, 13, 00), 5);
        availabilityMap.put(LocalDateTime.of(2023, Month.MARCH, 13, 10, 00), 5);

        bookingSystemManager.updateAvailability(restaurant1.getId(), availabilityMap);
        List<Restaurant> restaurantList = bookingSystemManager.searchRestaurant(SearchFields.NAME, "ABC");

        bookingSystemManager.bookTable(restaurant1.getId(), 1, 4,LocalDateTime.of(2023, Month.MARCH, 12, 10, 00));
    }
}