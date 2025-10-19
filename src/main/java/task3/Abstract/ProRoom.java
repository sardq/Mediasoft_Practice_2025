package task3.Abstract;

public abstract class ProRoom extends Room{
    public ProRoom(int number) {
        super(number);
    }
    public ProRoom(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        super(number, maxPersonCount, pricePerNight, isBooked);
    }
}
