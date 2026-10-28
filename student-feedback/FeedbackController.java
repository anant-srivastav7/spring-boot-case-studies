package com.example.student_feedback;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	private ArrayList<Feedback> feedbackList = new ArrayList<>();

    @PostMapping
    public String submitFeedback(@RequestBody Feedback feedback) {
        feedbackList.add(feedback);
        return "Feedback submitted successfully";
    }

    @GetMapping
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

}
