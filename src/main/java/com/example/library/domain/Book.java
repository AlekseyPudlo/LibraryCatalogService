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
}
