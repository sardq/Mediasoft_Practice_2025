package task3.Implementation;

import task3.Exceptions.RoomAlreadyBookedException;
import task3.Exceptions.RoomAlreadyFreeException;
import task3.Interfaces.LuxRoomService;
import task3.Interfaces.RoomService;
import task3.Rooms.LuxRoom;

public class DefaultLuxRoomService <T extends LuxRoom> implements RoomService<T>, LuxRoomService<T> {
    @Override
    public void foodDelivery(T luxRoom) {
        System.out.println("Доставка еды в люкс комнату " + luxRoom.getNumber() + " выполнена.");
    }

    @Override
    public void clean(T room) {
        System.out.println("Люкс комната " + room.getNumber() + " очищена.");
    }

    @Override
    public void reserve(T room) {
        if (!room.getIsBooked()) {
            room.setIsBooked(true);
            System.out.println("Люкс комната " + room.getNumber() + " успешно забронирована.");
        } else {
            throw new RoomAlreadyBookedException("Люкс комната " + room.getNumber() + " уже забронирована!");
        }
    }

    @Override
    public void free(T room) {
        if (room.getIsBooked()) {
            room.setIsBooked(false);
            System.out.println("Люкс комната " + room.getNumber() + " освобождена.");
        } else {
            throw new RoomAlreadyFreeException("Люкс комната " + room.getNumber() + " уже освобождена!");
        }
    }
}
