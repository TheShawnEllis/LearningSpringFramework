package learning.springframework.spring5webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    String addressLine1;
    String city;
    String state;
    String zip;


    public Publisher() {
    }

    public Publisher(String addressLine1, String city, String state, String zip) {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAddress() { return addressLine1; }
    public void setAddress(String address) { this.addressLine1 = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public Set<Book> getBooks() { return books; }
    public void setBooks(Set<Book> books) { this.books = books; }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", address='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
