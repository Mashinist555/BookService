package com.summerschool.bookservice.beans;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Book.find", query = "from Book where bookName like :name")
})
@Table(name = "book")
public class Book {

    @JsonView(View.Summary.class)
    private long bookId;

    @JsonView(View.Summary.class)
    private String bookName;

    @JsonView(View.Summary.class)
    private String description;

    private User owner;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookId ^ (bookId >>> 32));
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "book_owner")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
