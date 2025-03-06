package view.BookDTO;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookDTO  {
    private StringProperty author;
    public StringProperty authorProperty(){
        if(author==null)
        {
            author= new SimpleStringProperty(this,"author");
        }
        return author;
    }

    public void setAuthor(String author) {
        authorProperty().set(author);
    }
    public String getAuthor(){
        return authorProperty().get();
    }
    private StringProperty title;
    public void setTitle(String title) {
        titleProperty().set(title);
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public StringProperty titleProperty() {
        if (title == null) {
            title = new SimpleStringProperty(this, "title");
        }
        return title;
    }


}
