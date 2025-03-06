package service;

import model.Book;

import java.util.List;

public interface BookService {
    List<Book> finaAll();
    Book findById(Long Id);
    boolean save(Book book);
    boolean delete(Book book);
    int getAgeOfBook(Long Id);
}
