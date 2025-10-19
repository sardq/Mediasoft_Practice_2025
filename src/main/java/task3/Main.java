package task3;

import task3.Abstract.Room;
import task3.Exceptions.RoomAlreadyBookedException;
import task3.Exceptions.RoomAlreadyFreeException;
import task3.Implementation.DefaultLuxRoomService;
import task3.Implementation.DefaultRoomService;
import task3.Rooms.EconomyRoom;
import task3.Rooms.LuxRoom;
import task3.Rooms.StandardRoom;
import task3.Rooms.UltraLuxRoom;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<Room>(List.of(new EconomyRoom(101), new StandardRoom(102), new UltraLuxRoom(103), new LuxRoom(104)));
        for (Room room : rooms) {
            System.out.println(room);
        }
        DefaultRoomService<Room> roomService = new DefaultRoomService<Room>();
        DefaultLuxRoomService<LuxRoom> luxRoomService = new DefaultLuxRoomService<LuxRoom>();
        //Бронирование
        for (Room room : rooms) {
            try {
                if (room instanceof LuxRoom lux)
                    luxRoomService.reserve(lux);
                else
                    roomService.reserve(room);
            } catch (RoomAlreadyBookedException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        //проверка исключений
        for (Room room : rooms) {
            try {
                if (room instanceof LuxRoom lux)
                    luxRoomService.reserve(lux);
                else
                    roomService.reserve(room);
            } catch (RoomAlreadyBookedException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        //Освобождение
        for (Room room : rooms) {
            try {
                if (room instanceof LuxRoom lux)
                    luxRoomService.free(lux);
                else
                    roomService.free(room);
            } catch (RoomAlreadyFreeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        //проверка исключений
        for (Room room : rooms) {
            try {
                if (room instanceof LuxRoom lux)
                    luxRoomService.free(lux);
                else
                    roomService.free(room);
            } catch (RoomAlreadyFreeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        //Уборка
        for (Room room : rooms) {
            if (room instanceof LuxRoom lux)
                luxRoomService.clean(lux);
            else
                roomService.clean(room);
        }
        //доставка еды
        for (Room room : rooms) {
            if (room instanceof LuxRoom lux) {
                luxRoomService.foodDelivery(lux);
            }
        }
    }
}
