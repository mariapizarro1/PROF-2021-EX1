package test.java.es.upm.grise.profundizacion.control_1;

import org.junit.Test;

import main.java.es.upm.grise.profundizacion.control_1.DuplicatedBookException;
import main.java.es.upm.grise.profundizacion.control_1.Library;
import main.java.es.upm.grise.profundizacion.control_1.Book;
import main.java.es.upm.grise.profundizacion.control_1.EmptyLibraryException;
import main.java.es.upm.grise.profundizacion.control_1.NonExistingBookException;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class LibraryTest {
	
	@Test
	public void test(){
		fail();
	}
	
	@Test
	public void addBookTest() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Library myLibrary = new Library();
		Book libro1 = new Book("Harry Potter 1");

		//añadir libro 1 a la libreria
		myLibrary.addBook(libro1);
		assertEquals(libro1, myLibrary.getBook("Harry Potter 1"));
		
	}

	@Test
	public void duplicatedBookTest() throws DuplicatedBookException{
		Library myLibrary = new Library();
		Book libro1 = new Book("Harry Potter 1");
		Book libro2 = new Book("Harry Potter 1");
		myLibrary.addBook(libro1);
		assertThrows(DuplicatedBookException.class, () -> myLibrary.addBook(libro2));
	}



	@Test 
	public void removeBookTest() throws NonExistingBookException, DuplicatedBookException{
		Library myLibrary = new Library();
		Book libro3 = new Book("Harry Potter 2");
		myLibrary.addBook(libro3);
		myLibrary.removeBook(libro3);
		assertThrows(NonExistingBookException.class, () -> myLibrary.getBook("Harry Potter 2"));
		//mirar si el libro se ha borrado bien
	}
	@Test 
	public void removeNonExistingBookTest() throws NonExistingBookException{
		Library myLibrary = new Library();
		Book libro3 = new Book("Harry Potter 2");
		myLibrary.removeBook(libro3);
		assertThrows(NonExistingBookException.class, () -> myLibrary.getBook("Harry Potter 2"));

	}
	@Test 
	public void removeBookEmptyListTest() throws EmptyLibraryException{
		Library myLibrary = new Library();
		Book libro3 = new Book("Harry Potter 2");
		myLibrary.removeBook(libro3);
		assertThrows(EmptyLibraryException.class, () -> myLibrary.getBook("Harry Potter 2"));

	}


	@Test
	public void getBookTest() throws DuplicatedBookException{
		Library myLibrary = new Library();
		Book libro3 = new Book("Harry Potter 2");
		myLibrary.addBook(libro3);
		assertThrows(NonExistingBookException.class, () -> myLibrary.getBook("Harry Potter 2"));
	}

	@Test
	public void getBookEmptyListTest() throws EmptyLibraryException{
		Library myLibrary = new Library(); 
		Book libro3 = new Book("Harry Potter 2");
		assertThrows(EmptyLibraryException.class, () -> myLibrary.getBook("Harry Potter 1"));
	}

	@Test
	public void getBookNonExistingTest() throws NonExistingBookException, DuplicatedBookException{
		Library myLibrary = new Library(); 
		Book libro3 = new Book("Harry Potter 2");
		Book libro4 = new Book("Harry Potter 3");
		myLibrary.addBook(libro4);
		assertThrows(NonExistingBookException.class, () -> myLibrary.getBook("Harry Potter 2"));
	}

}
