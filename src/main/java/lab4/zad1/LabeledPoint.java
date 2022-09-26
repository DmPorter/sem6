package lab4.zad1;

import java.util.Objects;

class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(String label, double x, double y){
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return super.toString() +
                "{label='" + label +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (!(o instanceof LabeledPoint that)) return false;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }
}