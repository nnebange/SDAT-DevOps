package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreation() {
        Book book = new Book("1984", "George Orwell");
        assertEquals("1984", book.getTitle());
        assertTrue(book.isAvailable());
    }

    @Test
    void testBorrowBook() {
        Book book = new Book("1984", "George Orwell");
        book.borrowBook();
        assertFalse(book.isAvailable());
    }

    @Test
    void testReturnBook() {
        Book book = new Book("1984", "George Orwell");
        book.borrowBook();
        book.returnBook();
        assertTrue(book.isAvailable());
    }
}
