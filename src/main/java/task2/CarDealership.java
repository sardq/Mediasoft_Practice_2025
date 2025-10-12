package task2;

import task2.enums.TypeOfCar;

import java.util.List;
import java.util.Objects;

public class CarDealership{
    private List<Car> cars;
    CarDealership ( List<Car> cars)
    {
        this.cars = cars;
    }
    public List<Car> getCars() {
        return cars;
    }
    public boolean addCar(Car car){
        if(cars.contains(car)){
            System.out.println("Машина с "+ car.getVin()+" уже существует");
            return  false;
        }
        cars.add(car);
        return  true;
    }
    public List<Car> findByManufacturer(String manufacturer)
    {
        return cars
                .stream()
                .filter(car -> Objects.equals(car.getManufacturer(), manufacturer))
                .toList();
    }
    public double averageByType (TypeOfCar type)
    {
        return  cars
                .stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }
    public  List<Car> sortedByYear(){
        return cars
                .stream()
                .sorted()
                .toList();
    }

}
