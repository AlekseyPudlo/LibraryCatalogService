package com.example.library.domain;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String firstName;

  @NotBlank
  @Column(nullable = false)
  private String lastName;

  @Email
  private String email;

  @Size(max = 1000)
  private String bio;

  @OneToMany(mappedBy = "author")
  private Set<Book> books;

  // Constructor, getters, setters
}