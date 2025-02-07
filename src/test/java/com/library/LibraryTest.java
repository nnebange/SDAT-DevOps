package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {

    @Test
    public void testIssueBook() {
        Library library = new Library();
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");

        library.addBook(book);
        assertTrue(library.issueBook(user, book), "Book should be successfully issued");
        assertFalse(book.isAvailable(), "Book should not be available after issuance");
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");

        library.addBook(book);
        library.issueBook(user, book);
        
        assertFalse(book.isAvailable(), "Book should be unavailable after issuing");
        assertTrue(library.returnBook(user, book), "Book should be successfully returned");
        assertTrue(book.isAvailable(), "Book should be available after return");
    }

    @Test
    public void testSearchCatalog() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1");
        Book book2 = new Book("Title2", "Author2");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> results = library.searchCatalog("Title1");
        assertEquals(1, results.size(), "Search should return one result");
        assertEquals(book1, results.get(0), "Search should return the correct book");
    }

    @Test
    public void testIssueBookFailsForNonExistingBook() {
        Library library = new Library();
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");

        assertFalse(library.issueBook(user, book), "Should not be able to issue a book not in the library");
    }

    @Test
    public void testReturnBookFailsForNonBorrowedBook() {
        Library library = new Library();
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");

        library.addBook(book);
        assertFalse(library.returnBook(user, book), "Should not be able to return a book that was not borrowed");
    }
}
