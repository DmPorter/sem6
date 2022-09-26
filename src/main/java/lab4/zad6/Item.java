package lab4.zad6;

import java.util.Objects;

public class Item {
    private final String description;
    private final double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        return Double.compare(item.price, price) == 0 &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}