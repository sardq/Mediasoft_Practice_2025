package task3.Interfaces;

import task3.Rooms.LuxRoom;

public interface LuxRoomService<T extends LuxRoom> {
    void foodDelivery(T luxRoom);
}
