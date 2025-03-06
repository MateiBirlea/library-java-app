package service;

import model.Book;
import repository.BookRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BookServiceImpl implements BookService{
    private final BookRepository bookrepository;
    public BookServiceImpl(BookRepository b)
    {
        this.bookrepository=b;
    }
    @Override
    public List<Book> finaAll() {
        return bookrepository.findAll();
    }

    @Override
    public Book findById(Long Id) {
        return bookrepository.findById(Id).orElseThrow(()-> new IllegalArgumentException("Book with id : %d ws not found"));
    }

    @Override
    public boolean save(Book book) {
        return bookrepository.save(book);
    }

    @Override
    public boolean delete(Book book) {
        return bookrepository.delete(book);
    }

    @Override
    public int getAgeOfBook(Long Id) {
        Book book=this.findById(Id);
        LocalDate now =LocalDate.now();
        return (int) ChronoUnit.YEARS.between(book.getPublishedDate(),now);
    }
}
