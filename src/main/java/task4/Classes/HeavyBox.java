package task4.Classes;

import task4.Annotations.JsonField;

public class HeavyBox {
    @JsonField(name = "weight")
    private double weight;

    public HeavyBox(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
