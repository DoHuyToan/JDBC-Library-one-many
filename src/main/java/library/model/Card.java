package library.model;

public class Card {
    private int id;
    private Book book;
    private Student student;
    private boolean status;
    private String borrowDate;
    private String  payDate;

    public Card(int id, Book book, Student student, boolean status, String borrowDate, String payDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
    }

    public Card(Book book, Student student, String borrowDate, String payDate) {
        this.book = book;
        this.student = student;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
    }

    public Card(Book book, Student student, boolean status, String borrowDate, String payDate) {
        this.book = book;
        this.student = student;
        this.status = status;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
