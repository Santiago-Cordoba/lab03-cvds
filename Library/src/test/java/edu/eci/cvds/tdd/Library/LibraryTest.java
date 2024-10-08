package edu.eci.cvds.tdd.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class LibraryTest {

    private Library library;
    private Book book;
    private User user;
    private Loan Loan;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("opera", "Homero", "1023");
        user = new User("John Doe", "jdoe123");
        Loan = new Loan(book,user,LocalDateTime.now());
    }

    /**
     * Check that the loan exist
     */
    @Test
    void returnLoan(){
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
    void returnLoanNumberOfBookIncrement(){
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        Map<Book, Integer> books = library.getBooks();
        int cantiadadLibros = books.get(book);
        assertEquals(1, cantiadadLibros);
    }

    /**
     * Check the status of loan
     */
    @Test 
    void returnLoanStatusShouldBeReturned(){
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED,loan.getStatus());
    }

    /**
     * check that the date is updated in returnLoan
     */
    @Test
    void returnLoanActualDate(){
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        assertEquals(LocalDateTime.now(),loan.getReturnDate());
    }


    //Puedes agregar más pruebas para los otros métodos a medida que los implementes.
    @Test
    void testAddBook() {
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        boolean respuesta = books.containsKey(book);
        assertTrue(respuesta, "The book should be in the library");
    }

    @Test
    void addBookTestIfRepeated() {
        library.addBook(book);
        library.addBook(book);
        Map<Book, Integer> books = library.getBooks();
        int repeticiones = books.get(book);
        assertEquals(2, repeticiones);
    }

    @Test
    void addBookTestIfBookIsNull() {
        Book bookNull = null;
        boolean result = library.addBook(bookNull);
        assertFalse(result);
    }

    @Test
    void addLoan() {
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertEquals(loan.getBook(), Loan.getBook()); 
        assertEquals(loan.getUser(), Loan.getUser()); 
    }

    @Test
    void addLoanUserAndBookFalse() {
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNull(loan); 
    }

    @Test
    void addLoanBookShrinkage () {
        library.addBook(book);
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        int number = library.getBooks().get(book);
        assertEquals(1,number);
    }

    //Prueba
}
