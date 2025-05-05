package com.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

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

  @NotBlank
  private Set<Loan> loans;
}
