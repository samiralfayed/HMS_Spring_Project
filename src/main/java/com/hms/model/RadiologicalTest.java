package com.hms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("RadiologicalTest")  // dtype value for RadiologicalTest
public class RadiologicalTest extends LabTest {

    private String plateDimension;  // Specific field for RadiologicalTest

    // Constructor
    public RadiologicalTest() {}

    public RadiologicalTest(String title, String type, double cost, boolean available, String plateDimension) {
        super(title, cost, available);
        this.plateDimension = plateDimension;

    }

    @Override
    public String returnLabTestInfo() {
        return "Radiological Test: " + getTitle() + ", Plate Dimension: " + plateDimension ;
    }
}
