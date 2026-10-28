package com.example.complaint_management;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	private ArrayList<Complaint> complaints = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public Complaint registerComplaint(@RequestBody Complaint complaint) {

        if (complaint.getDescription() == null ||
            complaint.getDescription().trim().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Description is required");
        }

        if (complaint.getCategory() == null ||
            complaint.getCategory().trim().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Category is required");
        }

        String category = complaint.getCategory().trim();

        if (!category.equalsIgnoreCase("Classroom") &&
            !category.equalsIgnoreCase("Wi-Fi") &&
            !category.equalsIgnoreCase("Library")) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Category must be Classroom, Wi-Fi, or Library");
        }

        Complaint newComplaint = new Complaint(
            nextId++,
            complaint.getDescription().trim(),
            category,
            "PENDING"
        );

        complaints.add(newComplaint);
        return newComplaint;
    }

    @GetMapping
    public ArrayList<Complaint> getAllComplaints() {
        return complaints;
    }

}
