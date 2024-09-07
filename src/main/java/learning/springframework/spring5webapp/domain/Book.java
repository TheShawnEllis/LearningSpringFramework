package learning.springframework.spring5webapp.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

//LEARNING: '@' indicates that what follows is an annotations, to add metadata to code
//  @Entity annotation is used to mark the class as a JPA entity
//  @Id annotation is used to mark the field of a class as a primary key
//  @GeneratedValue annotation is used to mark the field of a class as auto-incremented
//  @ManyToMany annotation is used to mark the field of a class as a many-to-many relationship
//  @JoinTable annotation is used to mark the field of a class as a join table


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    private String title;
    private String isbn;


    public Book() {
    }

    public Book (String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }

    //LEARNING: Its good practice to add a custom to print user-friendly output for example in logging.
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    //LEARNING: When working with entities, it is important to implement equals() and hashCode() methods to compare, identify, and search when managing objects.
    //  The equals() method compares the current object with the object passed as an argument and returns true if they are equal.
    //  The hashCode() method returns a hash code value for the object. This value is used to identify the object in a collection.
    // The equals() and hasCode() methods can be auto-generated.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);

        // Code from lesson (2.15)
        // return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);

        // Code from lesson (2.15)
        // return id != null ? id.hashCode() : 0;
    }
}
