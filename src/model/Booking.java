package model;

import java.time.LocalDateTime;

public class Booking {
    int userId;
    int reataurantID;
    LocalDateTime time;
    int noOfPersons;

    public Booking(LocalDateTime time, int id, int userId, int noOfPersons) {
        this.time = time;
        this.userId = userId;
        this.noOfPersons = noOfPersons;
        reataurantID = id;

    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId=" + userId +
                ", reataurantID=" + reataurantID +
                ", time=" + time +
                ", noOfPersons=" + noOfPersons +
                '}';
    }
//to Do - make booking repo to save all booking
    //make user entity and repo to save users
}
