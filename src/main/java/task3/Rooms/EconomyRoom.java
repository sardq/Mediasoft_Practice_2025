package task3.Rooms;

import task3.Abstract.Room;
import task3.Enums.RoomPricesEnum;

import java.util.Random;

public class EconomyRoom extends Room {
    public EconomyRoom(int number) {
        super(number);
        Random rand = new Random();
        setMaxPersonCount(rand.nextInt(2) + 1);
        setPricePerNight(RoomPricesEnum.ECONOM.getPrice());
    }
    public EconomyRoom(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        super(number, maxPersonCount, pricePerNight, isBooked);
    }
}
