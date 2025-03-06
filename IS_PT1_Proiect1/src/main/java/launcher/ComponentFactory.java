package launcher;

import controler.BookControler;
import database.DataBaseConnectionFactory;
import javafx.stage.Stage;
import mapper.BookMapper;
import model.Book;
import repository.BookRepository;
import repository.BookRepositoryMySql;
import service.BookService;
import service.BookServiceImpl;
import view.BookDTO.BookDTO;
import view.BookView;

import java.sql.Connection;
import java.util.List;

public class ComponentFactory {

    private final BookView bookview;
    private final BookControler bookcontroler;

    private final BookRepository bookRepository;

    private final BookService bookService;

    private static ComponentFactory instance;

    public static ComponentFactory getInstance(Boolean componentsForTest, Stage primarystage){
        if(instance==null)
        {
            synchronized (ComponentFactory.class)
            {
                instance = new ComponentFactory(componentsForTest,primarystage);
            }
        }
        return instance;
    }

    public ComponentFactory(Boolean componentsForTest, Stage primarystage){
        Connection connection= DataBaseConnectionFactory.getConnectionWrapper(componentsForTest).getConnection();
        this.bookRepository=new BookRepositoryMySql(connection);
        this.bookService=new BookServiceImpl(bookRepository);
        List<BookDTO> bookDTOS= BookMapper.convertBookLIsttoBookDTOlIST(bookService.finaAll());
        this.bookview=new BookView(primarystage,bookDTOS);
        this.bookcontroler = new BookControler(bookview, bookService);


    }


    public BookView getBookview() {
        return bookview;
    }

    public BookControler getBookcontroler() {
        return bookcontroler;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public BookService getBookService() {
        return bookService;
    }

    public static ComponentFactory getInstance() {
        return instance;
    }
}
