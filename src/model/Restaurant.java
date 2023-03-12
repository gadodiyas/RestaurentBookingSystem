package model;

import model.enums.RestaurantType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Restaurant {
    static int cnt = 0;
    private int id;
    private String name;
    private String cityName;
    private String area;
    private List<String> cuisine = new ArrayList<>();
    private Double costForTwo;
    private RestaurantType restaurantType;
    private int maxDaysForFutureDates;
    private TreeMap<LocalDateTime, Integer> availableSlots = new TreeMap<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public String getArea() {
        return area;
    }

    public List<String> getCuisine() {
        return cuisine;
    }

    public Double getCostForTwo() {
        return costForTwo;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public int getMaxDaysForFutureDates() {
        return maxDaysForFutureDates;
    }

    public TreeMap<LocalDateTime, Integer> getAvailableSlots() {
        return availableSlots;
    }

    public Restaurant(int id) {
        this.id = id;
    }

    private Restaurant() {

    }

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder{
        Restaurant restaurant;

        public Builder() {
            this.restaurant =  new Restaurant();
        }

        public Builder setName(String name){
            restaurant.name = name;
            return this;
        }
        public Builder setCityName(String name){
            restaurant.cityName = name;
            return this;
        }
        public Builder setAreaName(String name){
            restaurant.area = name;
            return this;
        }
        public Builder setCuisineList(List<String> cuisineList){
            restaurant.cuisine.addAll(cuisineList);
            return this;
        }
        public Builder setCostForTow(Double cost){
            restaurant.costForTwo = cost;
            return this;
        }
        public Builder setMaxFutureDays(int day){
            restaurant.maxDaysForFutureDates = day;
            return this;
        }
        public Builder setRestaurantType(RestaurantType type){
            restaurant.restaurantType = type;
            return this;
        }

        public Restaurant build() {
            restaurant.id = ++cnt;
            return restaurant;
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                ", area='" + area + '\'' +
                ", cuisine=" + cuisine +
                ", costForTwo=" + costForTwo +
                ", restaurantType=" + restaurantType +
                ", maxDaysForFutureDates=" + maxDaysForFutureDates +
                ", availableSlots=" + availableSlots +
                '}';
    }
}
