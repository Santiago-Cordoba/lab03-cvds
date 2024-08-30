package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

public class LibraryTest {

    private Library library;
    private Book book;
    private User user;
    private Loan Loan;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("1002", "Opera", "Homero");
        user = new User("John Doe", "jdoe123");
        Loan = new Loan(book,user,LocalDateTime.now());
    }

    @Test
    public void testAddBook() {
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        boolean respuesta = books.containsKey(book);
        assertTrue(respuesta, "The book should be in the library");
    }

    @Test
    public void addBookTestIfRepeated() {
        library.addBook(book);
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        int repeticiones = books.get(book);
        assertEquals(2, repeticiones);
    }

    @Test
    public void addBookTestIfBookIsNull() {
        Book bookNull = null;
        boolean result = library.addBook(bookNull);
        assertFalse(result);
    }

    @Test
    public void addLoan() {
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertEquals(loan.getBook(), Loan.getBook()); 
        assertEquals(loan.getUser(), Loan.getUser()); 
    }
}
