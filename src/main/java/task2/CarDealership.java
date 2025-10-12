package task2;

import task2.enums.TypeOfCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarDealership{
    private List<Car> cars;
    public CarDealership ( List<Car> cars)
    {
        this.cars = (cars == null) ? new ArrayList<>() : cars;
    }
    public List<Car> getCars() {
        return cars;
    }
    public boolean addCar(Car car){
        if(car == null) {
            System.out.println("Ошибка. Отсутствует объект");
            return false;
        }
        if (car.getType() == null ||
                car.getVin() == null || car.getVin().isBlank() ||
                car.getManufacturer() == null || car.getManufacturer().isBlank() ||
                car.getModel() == null || car.getModel().isBlank()) {
            System.out.println("Не все текстовые значения заполнены");
            return false;
        }
        if (!car.getVin().contains("VIN")|| !car.getVin().matches(".*\\d.*"))
        {
            System.out.println("Ошибка заполнения VIN");
            return false;
        }
        if (car.getPrice() <= 0) {
            System.out.println("Цена должна быть больше 0.");
            return false;
        }

        if (car.getMileage() < 0) {
            System.out.println("Пробег не может быть отрицательным.");
            return false;
        }

        if (car.getYearOfManufacture() < 1900 || car.getYearOfManufacture() > 2025) {
            System.out.println("Указан некорректный год выпуска: " + car.getYearOfManufacture());
            return false;
        }
        if(cars.contains(car)){
            System.out.println("Машина с "+ car.getVin()+" уже существует");
            return  false;
        }
        cars.add(car);
        System.out.println("Машина успешно добавлена: "+ car );
        return  true;
    }
    public boolean removeCarByVin(String vin) {
        if (vin == null || vin.isBlank()) {
            System.out.println("VIN не может быть пустым.");
            return false;
        }

        boolean removed = cars.removeIf(car -> car.getVin().equalsIgnoreCase(vin));

        if (removed) {
            System.out.println("Машина с VIN " + vin + " успешно удалена.");
        } else {
            System.out.println("Машина с VIN " + vin + " не найдена.");
        }
        return removed;
    }
    public List<Car> findByManufacturer(String manufacturer)
    {
        if(manufacturer == null || manufacturer.isBlank())
        {
            System.out.println("Не указан производитель");
            return null;
        }
        return cars
                .stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
    }
    public double averageByType (TypeOfCar type)
    {
        if (type == null)
        {
            System.out.println("Отсутствует тип машины");
            return  0;
        }
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
    public Map<TypeOfCar, Long> countByTypes () {
        return cars
                .stream()
                .collect(
                        Collectors.groupingBy(Car::getType,
                                Collectors.counting()
                        ));
    }
    public Car[] minMaxYears(){
        Car[] result = new Car[2];
        var list = sortedByYear();
        if (list.isEmpty()) return result;
        result[0] = list.get(list.size()-1);
        result[1] = list.get(0);
        return result;
    }
}
