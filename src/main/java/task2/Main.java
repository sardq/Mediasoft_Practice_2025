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
        System.out.printf("\nСредний возраст авто: '%.1f'\n", averageAge);
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
        List<String> uniqueModels = new ArrayList<>();
        for (String model : carModels) {
            if (!uniqueModels.contains(model)) {
                uniqueModels.add(model);
            }
        }
        uniqueModels.sort(Collections.reverseOrder());

        System.out.println("Список без дубликатов и с отсортированными моделями машин");
        System.out.println(uniqueModels);
        Set<String> sortedList = new HashSet<>(uniqueModels);
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
        System.out.println();
        CarDealership carDealership = new CarDealership(carList);
        Scanner sc = new Scanner(System.in);
        String input ="";
        while (!input.equals("quit"))
        {
            System.out.println("Доступные методы: printAll, removeCar, addCar, findByManufacturer, averageByType, sortedByYear, countByTypes, minMaxYears, quit");
            input = sc.nextLine();
            switch (input)
            {
                case "printAll":{
                    System.out.println("Все автомобили:");
                    carDealership.getCars().forEach(System.out::println);
                    break;
                }
                case "addCar":{
                    System.out.println("Добавить машину в автоцентр.\nВведите VIN (должно начинаться с VIN)");
                    String vin = sc.nextLine().trim().toUpperCase();
                    System.out.println("Введите модель");
                    String model = sc.nextLine();
                    System.out.println("Введите производителя");
                    String manufacturer = sc.nextLine();
                    System.out.println("Введите год выпуска");
                    int year = sc.nextInt();
                    System.out.println("Введите пробег");
                    double mileage = sc.nextDouble();
                    System.out.println("Введите цену");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Введите тип");
                    try {
                        TypeOfCar type = TypeOfCar.valueOf(sc.nextLine().trim().toUpperCase());
                        carDealership.addCar(new Car(vin, model, manufacturer, year, mileage, price, type));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: неверный тип машины. Доступные значения: " + Arrays.toString(TypeOfCar.values()));
                    }
                    break;
                }
                case "removeCar":
                {
                    System.out.println("Удалить машину из автоцентра.\nВведите VIN");
                    String vin = sc.nextLine().trim().toUpperCase();
                    carDealership.removeCarByVin(vin);
                    break;
                }
                case "findByManufacturer":{
                    System.out.println("Найти все машины указанного производителя\nВведите производителя");
                    String manufacturer = sc.nextLine();
                    System.out.println("Машины по производителю");
                    var list = carDealership.findByManufacturer(manufacturer);
                    list.forEach(System.out::println);
                    break;
                }
                case "averageByType":
                {
                    System.out.println("Средняя цена машин определенного типа.\nВведите тип машины");
                    try {
                        TypeOfCar type = TypeOfCar.valueOf(sc.nextLine().trim().toUpperCase());
                        var average = carDealership.averageByType(type);
                        DecimalFormat myFormat  = new DecimalFormat("#.##");
                        System.out.println("Средняя цена: " + myFormat.format(average));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: неверный тип машины. Доступные значения: " + Arrays.toString(TypeOfCar.values()));
                    }
                    break;
                }
                case "sortedByYear":
                {
                    System.out.println("Сортировка машин по году выпуска");
                    var list = carDealership.sortedByYear();
                    list.forEach(System.out::println);
                    break;
                }
                case "countByTypes":
                {
                    var statisticByCount = carDealership.countByTypes();
                    statisticByCount.forEach((type, count) -> System.out.println("Тип машины: '"+type +"', Количество: '"+count+"'"));
                    break;
                }
                case "minMaxYears":
                {
                    Car[] statisticYears = carDealership.minMaxYears();
                    System.out.println("Самая старая машина в наличии: " +statisticYears[0]);
                    System.out.println("Самая новая машина в наличии: " +statisticYears[1]);
                    break;
                }
            }
        }
    }
}
