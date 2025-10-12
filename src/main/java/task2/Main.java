package task2;

import task2.enums.TypeOfCar;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Массивы
        int [] yearOfManufacture  = new int[50];
        Random random = new Random();
        int currentYear = 2025;
        for (int i =0; i < yearOfManufacture.length; i++)
        {
            yearOfManufacture[i] = random.nextInt(2000,2026);
        }
        System.out.println("\nМассивы. Все годы выпуска автомобилей:");
        for (int year : yearOfManufacture) {
            System.out.print(year + " ");
        }
        System.out.println("\nМашины, выпущенные после 2015 года:");
        for (int year : yearOfManufacture) {
            if (year > 2015)
                System.out.print(year + " ");
        }
        int totalAge = 0;
        for (int year: yearOfManufacture) {
            totalAge += (currentYear - year);
        }
        double averageAge = (double) totalAge/yearOfManufacture.length;
        System.out.println("\nСредний возраст авто: '"+ averageAge +"'");
        //Коллекции
        List<String> carModels =
                new ArrayList<>(List.of("Toyota Camry", "BMW X5", "Tesla Model 3", "Tesla Model s",
                        "Tesla Model y", "Toyota Camry", "BMW X5", "Audi A6", "Ford Focus",
                        "Tesla Model 3", "Toyota Camry"));
        System.out.println("\nКоллекции. Список с названиями моделей машин");
        System.out.println(carModels);
        for (int i = 0; i < carModels.size(); i++) {
            if (carModels.get(i).toLowerCase().contains("tesla")) {
                carModels.set(i, "ELECTRO_CAR");
            }
        }
        System.out.println("Список с названиями моделей машин после проверки");
        System.out.println(carModels);
        var result = carModels.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println("Список без дубликатов и с отсортированными моделями машин");
        System.out.println(result);
        Set<String> sortedList = new HashSet<>(result);
        System.out.println("Итоговый Set");
        System.out.println(sortedList);
        //Equals и Hashcode
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("VIN1001", "Camry", "Toyota", 2020, 45000, 23000, TypeOfCar.SEDAN));
        cars.add(new Car("VIN1002", "Model 3", "Tesla", 2023, 15000, 47000, TypeOfCar.ELECTRIC));
        cars.add(new Car("VIN1003", "Model S", "Tesla", 2021, 25000, 65000, TypeOfCar.ELECTRIC));
        cars.add(new Car("VIN1004", "Model Y", "Tesla", 2024, 10000, 52000, TypeOfCar.ELECTRIC));
        cars.add(new Car("VIN1001", "Camry", "Toyota", 2020, 46000, 22800, TypeOfCar.SEDAN));
        cars.add(new Car("VIN1003", "Model 3", "Tesla", 2023, 15500, 47200, TypeOfCar.ELECTRIC));
        cars.add(new Car("VIN1001", "Camry", "Toyota", 2020, 45000, 23000, TypeOfCar.SEDAN));
        System.out.println("\nEquals и Hashcode. Список машин в HashSet");
        for (Car c : cars) {
            System.out.println(c);
        }
        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);
        System.out.println("Сортировка по году выпуска (от новых к старым):");
        for (Car c : sortedCars) {
            System.out.println(c);
        }
        //Stream Api
        List<Car> carList = new ArrayList<>(List.of(
                new Car("VIN1001", "Camry", "Toyota", 2020, 45000, 23000, TypeOfCar.SEDAN),
                new Car("VIN1002", "X5", "BMW", 2022, 30000, 55000, TypeOfCar.SUV),
                new Car("VIN1003", "Model 3", "Tesla", 2023, 15000, 47000, TypeOfCar.ELECTRIC),
                new Car("VIN1004", "Model S", "Tesla", 2021, 25000, 65000, TypeOfCar.ELECTRIC),
                new Car("VIN1005", "Model Y", "Tesla", 2024, 10000, 52000, TypeOfCar.ELECTRIC),
                new Car("VIN1006", "A6", "Audi", 2019, 60000, 35000, TypeOfCar.SEDAN),
                new Car("VIN1007", "Focus", "Ford", 2018, 80000, 18000, TypeOfCar.SEDAN),
                new Car("VIN1008", "Camry", "Toyota", 2021, 40000, 25000, TypeOfCar.SEDAN)
        ));
        System.out.println("\nStream API. Все автомобили:");
        carList.forEach(System.out::println);
        var mileageFilter = carList
                .stream()
                .filter(c -> c.getMileage() < 50000)
                .toList();
        System.out.println("Машины с пробегом меньше 50.000 км");
        mileageFilter.forEach(System.out::println);
        var sortedByPrice = carList
                .stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .toList();
        System.out.println("\nСортировка машин по цене (по убыванию):");
        sortedByPrice.forEach(System.out::println);
        System.out.println("\nТоп-3 самых дорогих машины:");
        sortedByPrice
                .stream()
                .limit(3)
                .forEach(System.out::println);
        var averageMileage = carList
                .stream()
                .mapToDouble(Car::getMileage)
                .average()
                .orElse(0);
        System.out.println("\nСредний пробег всех машин: '" + averageMileage + "'" );
        Map<String, List<Car>> groupedByManufacturer = carList
                .stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("\nГруппировка по производителю:" );
        groupedByManufacturer.forEach((manufacturer, list) -> {
            System.out.println(manufacturer + ":");
            list.forEach(car -> System.out.println("  " + car));
        });
        //Доп задания
        CarDealership carDealership = new CarDealership(carList);
        System.out.println("\nВсе автомобили:");
        carDealership.getCars().forEach(System.out::println);
        carDealership.addCar(new Car("VIN1001", "Camry", "Toyota", 2020, 45000, 23000, TypeOfCar.SEDAN));
        carDealership.addCar(new Car("VIN1009", "X5", "BMW", 2015, 78000, 45000, TypeOfCar.SUV));
        System.out.println("\nВсе автомобили:");
        carDealership.getCars().forEach(System.out::println);
        System.out.println("Машины по производителю");
        var list = carDealership.findByManufacturer("BMW");
        list.forEach(System.out::println);
        var average = carDealership.averageByType(TypeOfCar.SUV);
        DecimalFormat myFormat  = new DecimalFormat("#.##");
        System.out.println("Средняя цена: " + myFormat.format(average));
        System.out.println("Сортировка машин по году выпуска");
        list = carDealership.sortedByYear();
        list.forEach(System.out::println);


    }
}
