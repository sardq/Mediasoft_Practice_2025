package task4.Classes;

import task4.Annotations.JsonField;

import java.util.Objects;

public class Room {
    @JsonField(name = "number")
    private int number;
    @JsonField(name = "maxPersonCount")
    private int maxPersonCount;
    @JsonField(name = "pricePerNight")
    private int pricePerNight;
    private boolean isBooked;
    public Room(int number) {
        this.number = number;
        this.isBooked = false;
    }
    public Room(int number, int maxPersonCount, int pricePerNight, boolean isBooked) {
        this.number = number;
        this.maxPersonCount = maxPersonCount;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxPersonCount() {
        return maxPersonCount;
    }

    public void setMaxPersonCount(int maxPersonCount) {
        if (maxPersonCount > 0) {
            this.maxPersonCount = maxPersonCount;
        }
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        if (pricePerNight >= 0) {
            this.pricePerNight = pricePerNight;
        }
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean booked) {
        this.isBooked = booked;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " №" + number +
                " (до " + maxPersonCount + " чел., " +
                pricePerNight + " руб./ночь, " +
                (isBooked ? "занят" : "свободен") + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Room room = (Room) obj;
        return Objects.equals(number, room.number);
    }
}
