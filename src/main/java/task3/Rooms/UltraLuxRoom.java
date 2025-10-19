package task3.Rooms;

import task3.Enums.RoomPricesEnum;

import java.util.Random;

public class UltraLuxRoom extends LuxRoom{
    public UltraLuxRoom(int number) {
        super(number);
        Random rand = new Random();
        setMaxPersonCount(rand.nextInt(3) + 3);
        setPricePerNight(RoomPricesEnum.ULTRALUX.getPrice());
    }
    public UltraLuxRoom(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        super(number, maxPersonCount, pricePerNight, isBooked);
    }
}
