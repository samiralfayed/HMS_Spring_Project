package com.hms.service;

import com.hms.model.LabTest;

import java.util.List;

public interface LabTestService {

    // Save or update a LabTest
    LabTest saveLabTest(LabTest labTest);

    // Fetch all LabTests
    List<LabTest> fetchLabTestList();

    // Fetch LabTest by ID
    LabTest fetchLabTestById(long id);

    // Delete LabTest by ID
    void deleteLabTestById(long id);
}
