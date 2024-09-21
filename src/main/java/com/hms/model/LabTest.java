package com.hms.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PathologicalTest.class, name = "pathological"),
        @JsonSubTypes.Type(value = RadiologicalTest.class, name = "radiological")
})
public abstract class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private double cost;
    private boolean available;


    // Constructor
    public LabTest() {}

    public LabTest(String title, double cost, boolean available) {
        this.title = title;
        this.cost = cost;
        this.available = available;
    }

    // Abstract method
    public abstract String returnLabTestInfo();
}
