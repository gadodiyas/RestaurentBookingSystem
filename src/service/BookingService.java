package service;

import model.Booking;
import model.Restaurant;
import repo.RestaurantsRepo;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class BookingService {
    //to do make interface for booking service

    public void synchronized bookTable(Restaurant restaurant, int userId, int noOfPersons, LocalDateTime time) {
        //check if slot is available
        TreeMap<LocalDateTime, Integer> availability = restaurant.getAvailableSlots();
        if(availability.containsKey(time)){
            Booking booking = new Booking(time, restaurant.getId(), userId, noOfPersons);
            int no = availability.get(time);
            no--;
            if(no == 0){
                availability.remove(time);
            } else {
                availability.put(time, no);
            }
            System.out.println("Booked restaurant booked" + booking.toString());

        }
    }
}
