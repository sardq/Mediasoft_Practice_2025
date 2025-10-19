package task3.Exceptions;

public class RoomAlreadyFreeException extends RuntimeException{
    public RoomAlreadyFreeException() {
        super("Комната уже освобождена!");
    }

    public RoomAlreadyFreeException(String message) {
        super(message);
    }
}
