import database.DataBaseConnectionFactory;
import database.JDBConnectionWrapper;
import model.Book;
import model.builder.BookBuilder;
import repository.BookRepositoryMySql;
import service.BookServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {
        Book book =new BookBuilder().setTitle("Ion").setAuthor("Liviu Rebreanu").setpulisheddate(LocalDate.of(1910 ,10, 20)).setId((long) 1).bulid();
        Book book2 = new BookBuilder()
                .setTitle("Moromeții")
                .setAuthor("Marin Preda")
                .setpulisheddate(LocalDate.of(1955, 5, 25))
                .setId(2L)
                .bulid();

        // System.out.println(book.toString());
        //Connection connection=DataBaseConnectionFactory.getConnectionWrapper(false).getConnection();
        JDBConnectionWrapper d=new JDBConnectionWrapper("library");
        BookRepositoryMySql g=new BookRepositoryMySql(d.getConnection());
        BookServiceImpl q=new BookServiceImpl(g);
        q.save(book2);
    }
}
