package task3.Enums;

public enum RoomPricesEnum {
    ECONOM (800),
    STANDARD(1600),
    LUX(1800),
    ULTRALUX(2000);

    private final int price;

    RoomPricesEnum(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name() +" (" + price + "руб.)";
    }
}
