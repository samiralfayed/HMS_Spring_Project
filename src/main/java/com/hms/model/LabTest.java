package com.hms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public abstract class LabTest {
    @Id
    private long id;
    private String title;
    private double cost;
    private boolean available;

    // Default constructor
    public LabTest() {
    }

    // Parameterized constructor
    public LabTest(String title, double cost, boolean available) {
        this.title = title;
        this.cost = cost;
        this.available = available;
    }

    public abstract String returnLabTestInfo();

    @Override
    public String toString() {
        return "Test Name: " + title + "\n" +
                "Cost: " + cost + "\n" +
                "Availability: " + (available ? "Available" : "Not Available");
    }

    public abstract String show();
}
