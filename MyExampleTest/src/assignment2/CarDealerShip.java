/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.*;

/**
 *
 * @author pgn
 */
public class CarDealerShip
{

    private List<Car> carsForSale = new ArrayList<>();

    
    
    /**
     * Adds another car for sale but only if the value is not null, and only if
     * the car has a price greater than zero.
     *
     * @param car The car to add to list of cars for sale.
     */
    public void addCarForSale(Car car)
    {
        if ( car != null && car.getPrice() > 0){
            carsForSale.add(car);
        }
    }
    
    /**
     * Gets the total value of all cars for sale.
     * @return the total value of all cars for sale.
     */
    public double getTotalCarValues()
    {
        double totalValue = 0;
        for (Car car : carsForSale) {
            totalValue += car.getPrice();
        }
        return totalValue;
    }
    
    /**
     * Gets the cheapest car from the list ov cars for sale.
     * @return the cheapest car from the list ov cars for sale.
     */
    public Car getCheapestCar()
    {
        Car cheapestCar = new Car();
        for(Car car : carsForSale){
            if(car.getPrice() < cheapestCar.getPrice()){
                cheapestCar = car;
            }
        }
        return cheapestCar;
    }
    
    /**
     * Sells the car in the parameter.
     * @param car The car to be sold.
     */
    public void sellCar(Car car)
    {
        if (car != null){
            carsForSale.remove(car);
        }
    }

    /**
     * Nothing to do here
     * @return 
     */
    public List<Car> getCarsForSale()
    {
        return carsForSale;
    }
        
    /**
    * Sort the list of cars for sale in order from cheapest to most expensive
    */    
    public void sortCarsByPrice()
    {
        carsForSale.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }
    
    /**
    * Sort the list of cars for sale in order from slowest to fastest.
    */    
    public void sortCarsByMaxSpeed(){
        carsForSale.sort((o1, o2) -> (int) (o1.getMaxKilometersPerHour() - o2.getMaxKilometersPerHour()));
    }
    /**
     * Get a random car for sale.
     * @return a randomly selected car for sale.
     */
    public Car presentRandomCarToCustomer()
    {
        Random random = new Random();
        int randomIndexValue = random.nextInt(carsForSale.size());
        return carsForSale.get(randomIndexValue);
    }

}