package com.example.library.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class BookTest {
  private static final String TITLE = "Test Title";
  private static final String ISBN = "1234567890123";
  private static final LocalDate PUBLISHED_DATE = LocalDate.now();
  private static final int PAGE_COUNT = 100;
  private static final String DESCRIPTION = "A test book";
    

  @Test
  void shouldCreateBook() {
    Book book = new Book(TITLE, ISBN, PUBLISHED_DATE, PAGE_COUNT, DESCRIPTION);
    assertEquals(TITLE, book.getTitle());
    assertEquals(ISBN, book.getIsbn());
    assertEquals(PUBLISHED_DATE, book.getPublishedDate());
    assertEquals(PAGE_COUNT, book.getPageCount());
    assertEquals(DESCRIPTION, book.getDescription());
  }
}