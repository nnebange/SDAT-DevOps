package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCreation() {
        User user = new User("John Doe");
        assertEquals("John Doe", user.getName());
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    void testBorrowBook() {
        User user = new User("John Doe");
        Book book = new Book("1984", "George Orwell");

        assertTrue(user.borrowBook(book));
        assertFalse(book.isAvailable());
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    void testReturnBook() {
        User user = new User("John Doe");
        Book book = new Book("1984", "George Orwell");

        user.borrowBook(book);
        user.returnBook(book);

        assertTrue(book.isAvailable());
        assertEquals(0, user.getBorrowedBooks().size());
    }
}
