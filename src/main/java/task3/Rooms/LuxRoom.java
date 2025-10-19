package task3.Rooms;

import task3.Abstract.ProRoom;
import task3.Enums.RoomPricesEnum;

import java.util.Random;

public class LuxRoom extends ProRoom {
    public LuxRoom(int number) {
        super(number);
        Random rand = new Random();
        setMaxPersonCount(rand.nextInt(2) + 3);
        setPricePerNight(RoomPricesEnum.LUX.getPrice());
    }
    public LuxRoom(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        super(number, maxPersonCount, pricePerNight, isBooked);
    }
}
