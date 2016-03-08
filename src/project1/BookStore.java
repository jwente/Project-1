package project1;

import java.util.ArrayList;

/**
 * Created by npena9 on 3/8/2016.
 */
public class BookStore
{
    private ArrayList<Book> books;

    public BookStore()
    {
        books = new ArrayList<Book>();

        populateBookStore();
    }

    private void populateBookStore()
    {
        //Add Books here
        books.add(new Book("Operating Sytems Book", Genre.ComputerScience));
    }

    public ArrayList<Book> getBookList()
    {
        return books;
    }

    public Student rentBook(Student student, String name)
    {

        return null;
    }
}
