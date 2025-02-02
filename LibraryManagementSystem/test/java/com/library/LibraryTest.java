package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testAddAndSearchBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        assertNotNull(library.searchBook("1984"));
        assertNull(library.searchBook("Nonexistent Book"));
    }

    @Test
    void testIssueBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        User user = new User("Alice");

        library.addBook(book);
        library.addUser(user);

        assertTrue(library.issueBook("1984", user));
        assertFalse(library.issueBook("1984", user)); // Already issued
    }

    @Test
    void testReturnBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        User user = new User("Alice");

        library.addBook(book);
        library.addUser(user);
        library.issueBook("1984", user);

        library.returnBook("1984", user);

        assertTrue(book.isAvailable());
    }
}
