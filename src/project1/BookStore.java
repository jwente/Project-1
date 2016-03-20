package project1;

import sun.util.calendar.BaseCalendar;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void addBook(Book book)
    {
        books.add(book);
    }

    private void populateBookStore()
    {
        Connection connection = null;
        PreparedStatement ps;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" +
                    "databaseName=Project1", "admin", "Project1");

            ps = connection.prepareStatement("SELECT * FROM [Art Books]");
            ResultSet results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Art Book ID"), results.getString("Art Book Name"), results.getString("Book Catagory")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Business & Economics Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Business & Economics Book ID"), results.getString("Business & Economics Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Computer Science Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Computer Science Book ID"), results.getString("Computer Science Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Design Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Design Book ID"), results.getString("Design Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Education Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Education Book ID"), results.getString("Education Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Law Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Law Book ID"), results.getString("Law Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Mathematics Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Mathematics Book ID"), results.getString("Mathematics Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Music Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Music Book ID"), results.getString("Music Book Name"), results.getString("Book Category")));
            }

            ps = connection.prepareStatement("SELECT * FROM [Philosophy & Psychology Books]");
            results = ps.executeQuery();

            while(results.next())
            {
                addBook(new Book(results.getInt("Philosophy & Psychology Book ID"), results.getString("Philosophy & Psychology Book Name"), results.getString("Book Category")));
            }

//            for(int i = 0; i <  getAmountOfBooks(); i++)
//            {
//                System.out.printf("%s, %s, %d\n", books.get(i).getName(), books.get(i).getCategory().toString(), books.get(i).getID());
//            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Could not connect to database.");
        }

        //Add Books here
        //books.add(new Book("Operating Sytems Book", Genre.ComputerScience));
    }

    public ArrayList<Book> getBookListByGenre(Genre genre)
    {
        ArrayList<Book> list = new ArrayList<Book>();

        for(int i = 0; i < getAmountOfBooks(); i++)
        {
            if(books.get(i).getCategory() == genre)
            {
                list.add(books.get(i));
            }
        }

        return list;
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
