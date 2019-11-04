package io.github.arnabmaji19.model;

public class IssueDetail {
    private int bookId;
    private int studentId;
    private String issueDate;
    private String returnDate;

    public IssueDetail() {}

    public IssueDetail(int bookId, int studentId, String issueDate, String returnDate) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
