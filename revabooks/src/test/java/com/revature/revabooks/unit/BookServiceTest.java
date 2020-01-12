package com.revature.revabooks.unit;

import com.revature.revabooks.exceptions.ResourceNotFoundException;
import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.util.AppState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    BookService sut;
    BookRepository bookRepo = mock(BookRepository.class);
    WishlistRepository wishlistRepo = mock(WishlistRepository.class);
    AppState appState = mock(AppState.class);

    Set<Book> mockBooks = new HashSet<>();

    @Before
    public void setUp() {

        sut = new BookService(bookRepo, wishlistRepo);

        mockBooks.add(new Book()
                .setId(1).setIsbn("978-1234567890")
                .setTitle("Testing for Dummies")
                .setAuthor(new Author("Tester", "McTesterson"))
                .setGenre(Genre.TECHNICAL).setPrice(29.99).setStockCount(12));

        mockBooks.add(new Book()
                .setId(2).setIsbn("978-0987654321")
                .setTitle("Java for Dummies")
                .setAuthor(new Author("James", "Gosling"))
                .setGenre(Genre.TECHNICAL).setPrice(39.99).setStockCount(3));

        mockBooks.add(new Book()
                .setId(3).setIsbn("978-1234509876")
                .setTitle("Books for Dummies")
                .setAuthor(new Author("Ire", "Knee"))
                .setGenre(Genre.TECHNICAL).setPrice(19.99).setStockCount(0));
    }

    @After
    public void tearDown() {
        sut = null;
        mockBooks.removeAll(mockBooks);
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepo.findAll()).thenReturn(mockBooks);
        Set<Book> result = sut.getAllBooks();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testGetByIsbnWithValidKnownIsbn() {
        Optional<Book> _expectedResult = mockBooks.stream().filter(b -> b.getIsbn().equals("978-0987654321")).findFirst();
        when(bookRepo.findBookByIsbn(Mockito.anyString())).thenReturn(_expectedResult);
        Book result = sut.getBookByIsbn("978-0987654321");
        assertEquals(_expectedResult.get(), result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIsbnWithValidUnknownIsbn() {
        Optional<Book> _expectedResult = Optional.empty();
        when(bookRepo.findBookByIsbn(Mockito.anyString())).thenReturn(_expectedResult);
        sut.getBookByIsbn("978-0987654320");
    }

}
