package task3.Exceptions;

public class RoomAlreadyBookedException extends RuntimeException{
    public RoomAlreadyBookedException() {
        super("Комната уже забронирована!");
    }

    public RoomAlreadyBookedException(String message) {
        super(message);
    }
}
