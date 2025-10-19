package task3.Implementation;

import task3.Abstract.Room;
import task3.Exceptions.RoomAlreadyBookedException;
import task3.Exceptions.RoomAlreadyFreeException;
import task3.Interfaces.RoomService;

public class DefaultRoomService<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Комната " + room.getNumber() + " очищена.");
    }

    @Override
    public void reserve(T room) {
        if (!room.getIsBooked()) {
            room.setIsBooked(true);
            System.out.println("Комната " + room.getNumber() + " успешно забронирована.");
        } else {
            throw new RoomAlreadyBookedException("Комната " + room.getNumber() + " уже забронирована!");
        }
    }

    @Override
    public void free(T room) {
        if (room.getIsBooked()) {
            room.setIsBooked(false);
            System.out.println("Комната " + room.getNumber() + " освобождена.");
        } else {
            throw new RoomAlreadyFreeException("Комната " + room.getNumber() + " уже освобождена!");
        }
    }
}
