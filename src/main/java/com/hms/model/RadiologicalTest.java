package com.hms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

@Setter
@Getter
public class RadiologicalTest extends LabTest {
    private String plateDimension; // Fixed typo

    private static final Logger LOG = Logger.getLogger(RadiologicalTest.class.getName());

    public RadiologicalTest() {
        // Default constructor
    }

    public RadiologicalTest(String title, double cost, String plateDimension, boolean isAvailable) {
        super(title, cost, isAvailable); // Initialize superclass fields
        this.plateDimension = plateDimension; // Set specific field
    }

    @Override
    public String returnLabTestInfo() {
        return "Test Name: " + this.getTitle() + "\n<br>" +
                "Cost: " + this.getCost() + "\n<br>" +
                "Plate Dimension: " + this.getPlateDimension() + "\n<br>" +
                "Availability: " + (this.isAvailable() ? "Available" : "Not Available");
    }


    public String show() {
        return "Test Name: " + this.getTitle() + "\n<br>" +
                "Plate Dimension: " + this.getPlateDimension() + "\n<br>" +
                "Cost: " + this.getCost() + "\n<br>" +
                "Availability: " + (this.isAvailable() ? "Available" : "Not Available");
    }
}
