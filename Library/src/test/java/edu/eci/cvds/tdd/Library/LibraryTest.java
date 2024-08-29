package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryTest {

    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("10002", "Homero", "Opera"); // Corrige el orden de los parámetros si es necesario
    }

    @Test
    public void testAddBook() {
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        boolean respuesta = books.containsKey(book);
        assertTrue(respuesta, "The book should be in the library");
    }

    @Test
    public void addbokTestIfRepeated() {
        library.addBook(book);
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        int repeticiones = books.get(book);
        assertEquals(repeticiones,2);
    }

    


    
}
