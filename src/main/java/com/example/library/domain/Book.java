package com.example.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String title;

  @NotBlank
  @Column(nullable = false, unique = true, length = 13)
  private String isbn;

  @PastOrPresent
  private LocalDate publishedDate;

  @Min(1)
  private Integer pageCount;

  @NotBlank
  private String description;

  @ElementCollection
  @CollectionTable(
    name = "book_genres",
    joinColumns = @JoinColumn(name = "book_id")
  )
  @Column(name = "genre")
  private Set<@NotBlank String> genres;

  @ManyToMany
  @JoinTable(
    name = "book_authors",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors;

  @OneToMany(mappedBy = "book")
  private Set<Loan> loans;

  // Constructor, getters, setters
  public Book() {}

  public Book(String title, String isbn, LocalDate publishedDate, int pageCount, String description, Set<String> genres, Set<Author> authors) {
    this.title = title;
    this.isbn = isbn;
    this.publishedDate = publishedDate;
    this.pageCount = pageCount;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public Integer getPageCount() {
    return pageCount;
  }

  public String getDescription() {
    return description;
  }

  public Set<String> getGenres() {
    return genres;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public Set<Loan> getLoans() {
    return loans;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
