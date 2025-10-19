package task3.Rooms;

import task3.Abstract.ProRoom;
import task3.Enums.RoomPricesEnum;

import java.util.Random;

public class StandardRoom extends ProRoom {
    public StandardRoom(int number) {
        super(number);
        Random rand = new Random();
        setMaxPersonCount(rand.nextInt(2) + 2);
        setPricePerNight(RoomPricesEnum.STANDARD.getPrice());
    }
    public StandardRoom(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        super(number, maxPersonCount, pricePerNight, isBooked);
    }
}
