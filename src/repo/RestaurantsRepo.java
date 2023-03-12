package repo;

import exception.NoMatchFoundEception;
import exception.RestaurentNoFoundException;
import model.Restaurant;
import service.MyComparator;

import java.util.*;

public class RestaurantsRepo {

    Map<Integer, Restaurant> restaurants = new HashMap<>();

    public void add(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurant(int id) {

        Restaurant re =  restaurants.get(id);
        if(re == null) {
            throw new RestaurentNoFoundException("Restaurent:" + id + " not found");
        }
        return re;
    }

    public List<Restaurant> searchRestaurant(MyComparator c, String val) {
        List<Restaurant> res = new ArrayList<>();
        for(Restaurant r : restaurants.values()) {
            if(c.compare(r, val ))
                res.add(r);
        }
        if(res.isEmpty()){
            throw new NoMatchFoundEception("No matching restaurant");
        }
        displayList(res);
        return res;
    }

    public void displayList(List<Restaurant> restaurants) {
        for (Restaurant r : restaurants) {
            System.out.println(r.toString());
        }
    }
}
