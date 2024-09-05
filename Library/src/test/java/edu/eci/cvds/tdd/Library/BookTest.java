package edu.eci.cvds.tdd.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.eci.cvds.tdd.library.book.Book;


public class BookTest {

    @Test
    void testEqualsSameISBN() {
        Book book1 = new Book("Title1", "Author1", "ISBN1234");
        Book book2 = new Book("Title2", "Author2", "ISBN1234");
        assertTrue(book1.equals(book2));
    }

    @Test
    void testEqualsDifferentISBN() {
        Book book1 = new Book("Title1", "Author1", "ISBN1234");
        Book book2 = new Book("Title2", "Author2", "ISBN5678");
        assertFalse(book1.equals(book2));
    }

    @Test
    void testEqualsSameObject() {
        Book book = new Book("Title1", "Author1", "ISBN1234");
        assertTrue(book.equals(book));
    }

    @Test
    void testEqualsNull() {
        Book book = new Book("Title1", "Author1", "ISBN1234");
        assertFalse(book.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        Book book = new Book("Title1", "Author1", "ISBN1234");
        String notABook = "I'm not a book";
        assertFalse(book.equals(notABook));
    }
}
