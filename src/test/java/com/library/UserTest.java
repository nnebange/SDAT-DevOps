package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("John Doe");
        assertEquals("John Doe", user.getName());
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    public void testBorrowBook() {
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");
        user.borrowBook(book);
        assertFalse(book.isAvailable());
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBook() {
        User user = new User("John Doe");
        Book book = new Book("Title", "Author");
        user.borrowBook(book);
        user.returnBook(book);
        assertTrue(book.isAvailable());
        assertEquals(0, user.getBorrowedBooks().size());
    }
}
