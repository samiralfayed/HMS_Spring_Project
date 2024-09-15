package model;

import lombok.Getter;
import lombok.Setter;

public class LabTest {
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private double cost;
    private boolean isAvailable;

    // Default constructor
    public LabTest() {
    }

    // Parameterized constructor
    public LabTest(String title, double cost, boolean isAvailable) {
        this.title = title;
        this.cost = cost;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "LabTest{" + "title='" + title + '\'' + ", cost=" + cost + ", isAvailable=" + isAvailable + '}';
    }
}
