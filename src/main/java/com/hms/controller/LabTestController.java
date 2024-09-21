package com.hms.controller;

import com.hms.model.LabTest;
import com.hms.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labtests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    // Save a new LabTest (POST /labtests)
    @PostMapping
    public ResponseEntity<LabTest> saveLabTest(@RequestBody LabTest labTest) {
        LabTest savedLabTest = labTestService.saveLabTest(labTest);  // Save lab test using service
        return new ResponseEntity<>(savedLabTest, HttpStatus.CREATED);  // Return 201 Created with saved object
    }

    // Fetch all LabTests (GET /labtests)
    @GetMapping
    public ResponseEntity<List<LabTest>> fetchLabTestList() {
        List<LabTest> labTests = labTestService.fetchLabTestList();
        return new ResponseEntity<>(labTests, HttpStatus.OK);
    }

    // Fetch a specific LabTest by ID (GET /labtests/{id})
    @GetMapping("/{id}")
    public ResponseEntity<LabTest> fetchLabTestById(@PathVariable("id") long id) {
        LabTest labTest = labTestService.fetchLabTestById(id);
        if (labTest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 if LabTest not found
        }
        return new ResponseEntity<>(labTest, HttpStatus.OK);
    }

    // Update an existing LabTest (PUT /labtests/{id})
    @PutMapping("/{id}")
    public ResponseEntity<LabTest> updateLabTest(@PathVariable("id") long id, @RequestBody LabTest labTestDetails) {
        LabTest existingLabTest = labTestService.fetchLabTestById(id);
        if (existingLabTest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the existing lab test with new details
        existingLabTest.setTitle(labTestDetails.getTitle());
        existingLabTest.setCost(labTestDetails.getCost());
        existingLabTest.setAvailable(labTestDetails.isAvailable());

        LabTest updatedLabTest = labTestService.saveLabTest(existingLabTest);  // Save the updated LabTest
        return new ResponseEntity<>(updatedLabTest, HttpStatus.OK);
    }

    // Delete a LabTest by ID (DELETE /labtests/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLabTestById(@PathVariable("id") long id) {
        LabTest labTest = labTestService.fetchLabTestById(id);
        if (labTest == null) {
            return new ResponseEntity<>("LabTest not found with ID: " + id, HttpStatus.NOT_FOUND);  // Return 404 if LabTest not found
        }

        labTestService.deleteLabTestById(id);
        return new ResponseEntity<>("LabTest with ID " + id + " has been deleted successfully.", HttpStatus.OK);
    }
}
