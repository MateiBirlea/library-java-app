package repository.Book;

import model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    boolean save(Book book);
    boolean delete(Book book);
    boolean decrement(Book book);
    void removeAll();
    public String getBookname();
}
