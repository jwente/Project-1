package project1;

import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public int getAmountOfBooks()
    {
        return books.size();
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

    public Book searchByName(String bookName)
    {
        for(int i = 0; i < books.size(); i++)
        {
            if(books.get(i).getName().equalsIgnoreCase(bookName))
            {
                return books.get(i);
            }
        }

        return null;
    }

    public int getTotalCopiesOfBookByName(String bookName)
    {
        int total = 0;

        for(int i = 0; i < books.size(); i++)
        {
            if(books.get(i).getName().equalsIgnoreCase(bookName))
            {
                total++;
            }
        }

        return total;
    }

    public Faculty rentBook(Faculty faculty, String bookName)
    {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, 14);

        int index = books.indexOf(searchByName(bookName));

        if(faculty.rentBook(books.get(index), calendar))
        {
            books.remove(index);
        }
        else
        {
            System.out.printf("%s has already checked out %d books", faculty.getFirstName(), faculty.getBooksRented());
        }

        return faculty;
    }

    public Student rentBook(Student student, String bookName)
    {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, 7);

        int index = books.indexOf(searchByName(bookName));

        if(student.rentBook(books.get(index), calendar))
        {
            books.remove(index);
        }
        else
        {
            System.out.printf("%s has already checked out %d books", student.getFirstName(), student.getBooksRented());
        }

        return student;
    }
}
