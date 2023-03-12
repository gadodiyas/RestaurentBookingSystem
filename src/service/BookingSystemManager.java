package service;

import exception.NotValiSearchParameterException;
import model.enums.RestaurantType;
import model.enums.SearchFields;
import repo.RestaurantsRepo;
import model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class BookingSystemManager {

    RestaurantsRepo restaurantsRepo;

    BookingService bookingService;
    public BookingSystemManager() {
        this.restaurantsRepo = new RestaurantsRepo();
        bookingService = new BookingService();
    }

    public Restaurant registerRestaurant(Restaurant restaurant) {
        restaurantsRepo.add(restaurant);
        return restaurant;
    }

    public void updateAvailability(int id, Map<LocalDateTime, Integer> availabilityMap) {
        Restaurant restaurant = restaurantsRepo.getRestaurant(id);
        restaurant.getAvailableSlots().putAll(availabilityMap);
    }
    public List<Restaurant> searchRestaurant(SearchFields field, Object val) {

        switch(field){
            case AREA:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getArea().equals((String)y), val );
            case CITY:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getCityName().equals((String)y), val );
            case COST_FOR_TWO:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getCostForTwo().compareTo((Double) y) == 0 , val );
            case NAME:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getName().equals((String)y),val );
            case CUISINE:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getCuisine().contains((String)y), val );
            case RESTAURANT_TYPE:
                return restaurantsRepo.searchRestaurant(( x,  y)-> x.getRestaurantType().equals((RestaurantType) y),val );
            default:
                throw new NotValiSearchParameterException("Not Valid Search");

        }
    }

    public void bookTable(int restaurentId, int userId, int noOfPersons, LocalDateTime time) {
        Restaurant restaurant = restaurantsRepo.getRestaurant(restaurentId);
        bookingService.bookTable(restaurant, userId, noOfPersons, time);

    }
}
