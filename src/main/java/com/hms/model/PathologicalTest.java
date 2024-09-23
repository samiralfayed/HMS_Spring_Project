package com.hms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@DiscriminatorValue("PathologicalTest")
public class PathologicalTest extends LabTest {

    private String sampleType;


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
