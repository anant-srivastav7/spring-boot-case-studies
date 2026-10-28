package com.example.student_feedback;

public class Feedback {
	private String studentName;
    private String subject;
    private String feedback;

    public Feedback() {
    }

    public Feedback(String studentName, String subject, String feedback) {
        this.studentName = studentName;
        this.subject = subject;
        this.feedback = feedback;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
