package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class LibraryTest {

    private Library library;
    private Book book;
    private User user;
    private Loan Loan;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("opera", "Homero", "1023");
        user = new User("John Doe", "jdoe123");
        Loan = new Loan(book,user,LocalDateTime.now());
    }

    /**
     * Check that the loan exist
     */
    @Test
    public void returnLoan(){
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        List<Loan> loans = library.getLoans();
        assertTrue(loans.contains(loan));
        assertNotNull(library.returnLoan(loan));
    }

    /**
     * Check if the number of books increment
     */
    @Test 
    public void returnLoanNumberOfBookIncrement(){
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        Map<Book, Integer> books = library.getBooks();
        int cantiadadLibros = books.get(book);
        assertEquals(1, cantiadadLibros);
    }


    // Puedes agregar más pruebas para los otros métodos a medida que los implementes.
}
