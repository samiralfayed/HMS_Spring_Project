package com.hms.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("PathologicalTest")  // dtype value for PathologicalTest
public class PathologicalTest extends LabTest {

    private String sampleType;  // Specific field for PathologicalTest

    // Constructor
    public PathologicalTest() {}

    public PathologicalTest(String title, double cost, boolean available, String sampleType) {
        super(title, cost, available);
        this.sampleType = sampleType;
    }

    @Override
    public String returnLabTestInfo() {
        return "Pathological Test: " + getTitle() + ", Sample Type: " + sampleType;
    }
}
