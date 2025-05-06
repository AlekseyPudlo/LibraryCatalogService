# Library Catalog Service

A simple Java Spring Boot application for managing a library catalog, including books, authors, genres, and loans.

## Features

- Manage books with details like title, ISBN, authors, genres, and publication info
- Track book loans
- Organize authors and genres

## Project Structure

- `domain/` — JPA entities (Book, Author, Loan, etc.)
- `repository/` — Spring Data repositories
- `service/` — Business logic
- `controller/` — REST API endpoints

## Getting Started

1. **Clone the repository:**

   ```sh
   git clone git@github.com:AlekseyPudlo/LibraryCatalogService.git
   cd LibraryCatalogService
   ```

2. **Build the project:**

   ```sh
   ./gradlew build
   ```

3. **Run the application:**
   ```sh
   ./gradlew bootRun
   ```

## Requirements

- Java 17+
- Gradle (or use the included `gradlew` wrapper)

## License

MIT
