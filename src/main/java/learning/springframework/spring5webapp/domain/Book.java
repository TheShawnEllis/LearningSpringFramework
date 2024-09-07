package learning.springframework.spring5webapp.domain;

import jakarta.persistence.*;

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

}
