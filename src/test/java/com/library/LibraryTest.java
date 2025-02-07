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
        library.issueBook(user, book);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");
        library.addBook(book);
        library.issueBook(user, book);
        library.returnBook(user, book);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testSearchCatalog() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1");
        Book book2 = new Book("Title2", "Author2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> results = library.searchCatalog("Title1");
        assertEquals(1, results.size());
        assertEquals(book1, results.get(0));
    }
}
