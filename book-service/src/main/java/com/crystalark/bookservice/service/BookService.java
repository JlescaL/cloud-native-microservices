package com.crystalark.bookservice.service;

import com.crystalark.bookservice.DAO.BookDao;
import com.crystalark.bookservice.DTO.BookDTO;
import com.crystalark.bookservice.Exceptions.BookNotFoundException;
import com.crystalark.bookservice.models.Book;
import com.crystalark.bookservice.utils.ObjectMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class BookService {

    @Autowired
    private BookDao dao;

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @return list of all books of <code>List<BookDTO></code> type.
     */
    public Optional<List<BookDTO>> getAllBooks() {
        List<BookDTO> allBookDTOs = ObjectMapperUtility.mapAll((List<Book>) dao.findAll(), BookDTO.class);
        return Optional.of(allBookDTOs);
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param bookDTO
     *            Book details in JSON format
     * @return an object of <code>BookDTO</code> type.
     */
    public BookDTO saveBook(BookDTO bookDTO) {
        Book savedBook = dao.save(ObjectMapperUtility.map(bookDTO, Book.class));
        return Optional.of(ObjectMapperUtility.map(savedBook, BookDTO.class))
                .orElseThrow(() -> new BookNotFoundException(("Failed to save book : ")));
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param id
     *            Id of the book to be retrieved
     * @return return a book by id of <code>BookDTO</code> type.
     */
    public BookDTO getBookById(long id) {
        return Optional.of(ObjectMapperUtility.map(dao.findById(id), BookDTO.class))
                .orElseThrow(() -> new BookNotFoundException("No books with matching id " + id));

        // return Optional.of(dao.findById(id)).get().orElseThrow(()-> new BookNotFoundException("No books with
        // match"));
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param bookDTO
     *            Book details in JSON format
     * @param id
     *            Book id to be updated
     * @return return an updated book of <code>BookDTO</code> type.
     */
    public BookDTO updateBook(BookDTO bookDTO, long id) {

        Book b = dao.findById(id).map(book -> dao.save(book))
                .orElseThrow(() -> new BookNotFoundException("No books with matching id " + id));
        return ObjectMapperUtility.map(b, BookDTO.class);
    }
}