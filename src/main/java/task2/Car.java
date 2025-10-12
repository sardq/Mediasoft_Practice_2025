package task2;

import task2.enums.TypeOfCar;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String manufacturer;
    private int yearOfManufacture;
    private double mileage;
    private double price;
    private TypeOfCar type;

    public Car (String vin, String model, String manufacturer, int yearOfManufacture, double price, double mileage, TypeOfCar type)
    {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.mileage = mileage;
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public TypeOfCar getType() {
        return type;
    }

    public void setType(TypeOfCar type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Car car = (Car) obj;
        return Objects.equals(vin, car.vin);
    }
    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.yearOfManufacture, this.yearOfManufacture);
    }
    @Override
    public String toString() {
        return "VIN: '" + this.vin +
                "', Модель: '" + this.model +
                "', Производитель: '" + this.manufacturer +
                "', Год выпуска: '" + this.yearOfManufacture +
                "', Пробег: '" + this.mileage +
                " км.', Цена: '" + this.price +
                " руб.' Тип автомобиля: " +this.type + "'";
    }
}
