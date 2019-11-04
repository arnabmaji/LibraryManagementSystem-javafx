package io.github.arnabmaji19.model;

import com.mongodb.BasicDBList;
import org.bson.Document;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issuedQuantity;


    public Book() {
    }

    public Book(int bookId, String name, String author, String publisher, int quantity, int issuedQuantity) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issuedQuantity = issuedQuantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }
}
