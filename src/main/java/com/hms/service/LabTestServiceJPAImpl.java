package com.hms.service;

import com.hms.model.LabTest;
import com.hms.repository.LabTestJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
 LabTestServiceJPAImpl implements LabTestService {

    @Autowired
    private LabTestJPARepo labTestJPARepo;

    // Save or update LabTest
    @Override
    public LabTest saveLabTest(LabTest labTest) {
        return labTestJPARepo.save(labTest);
    }

    // Fetch all LabTests
    @Override
    public List<LabTest> fetchLabTestList() {
        return labTestJPARepo.findAll();
    }

    // Fetch LabTest by ID
    @Override
    public LabTest fetchLabTestById(long id) {
        return labTestJPARepo.findById(id).orElse(null);
    }

    // Delete LabTest by ID
    @Override
    public void deleteLabTestById(long id) {
        labTestJPARepo.deleteById(id);
    }
}
