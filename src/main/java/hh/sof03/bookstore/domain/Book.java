package hh.sof03.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String isbn;
    private int publicationYear;
    private double price;

    @ManyToOne 
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid") 
    private Category category;

    public Book() {}

    public Book(Long id,  String author,String title, String isbn, int publicationYear, double price, Category category) {
        this.id= id;
        this.author= author;
        this.title= title;
        this.isbn= isbn;
        this.publicationYear= publicationYear;
        this.price= price;
        this.category= category;
    }

     
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
     public String getIsbn() {
        return isbn;
    }
    public double getPrice() {
        return price;
    }
    public Category getCategory() {
        return category;
    }
    
     public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title =title;
    }
    public void setAuthor(String author) {
        this.author= author;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear= publicationYear;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(double price) {
        this.price= price;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    

    

    @Override
    public String toString() {
        if (this.category !=null)
        return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publicationYear="
                + publicationYear + ", price=" + price + ", category=" + this.getCategory() + "]";
                else
                    return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publicationYear="
                + publicationYear + ", price=" + price + "]";
    }
    
    }

