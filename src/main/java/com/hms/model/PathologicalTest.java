package com.hms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class PathologicalTest extends LabTest {

    private String reagent;

    public PathologicalTest(String title, String reagent, double cost, boolean isAvailable) {
        super(title, cost, isAvailable); // Initialize superclass fields
        this.reagent = reagent;
    }

    public PathologicalTest() {
        // Default constructor
    }

    @Override
    public String returnLabTestInfo() {
        return "Test Name: " + this.getTitle() + "\n<br>" +
                "Reagent Name: " + this.getReagent() + "\n<br>" +
                "Cost: " + this.getCost() + "\n<br>" +
                "Availability: " + (this.isAvailable() ? "Available" : "Not Available");
    }

    public void search(String title) {
        if (Objects.equals(this.getTitle(), title)) {
            System.out.println(returnLabTestInfo());
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String show() {

        return super.toString() + "\nReagent: " + this.getReagent();
    }
}
