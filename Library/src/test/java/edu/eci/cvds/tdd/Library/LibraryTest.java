package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setUp() {
        // Inicializa la instancia de Library antes de cada prueba
        library = new Library();
    }


    // Puedes agregar más pruebas para los otros métodos a medida que los implementes.
}
