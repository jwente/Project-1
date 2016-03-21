package project1;

import sun.util.calendar.BaseCalendar;

import javax.swing.*;
import java.sql.*;
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

    public String rentBook(String bookName)
    {
        Calendar calendar = Calendar.getInstance();

        if(Main.user.getStatus().equalsIgnoreCase("Student"))
        {
            calendar.add(Calendar.DAY_OF_YEAR, 7);

            Book book = searchByName(bookName);

            if(book == null)
            {
                return "Book cannot be found";
            }

            int index = books.indexOf(book);

            String msg = ((Student)Main.user).rentBook(books.get(index), calendar);

            if(msg == null)
            {
                addToHistory(book, calendar);
                books.remove(index);
                return null;
            }
            else
            {
                return msg;
            }
        }
        else
        {
            calendar.add(Calendar.DAY_OF_YEAR, 14);

            Book book = searchByName(bookName);

            int index = books.indexOf(book);

            String msg = ((Faculty)Main.user).rentBook(books.get(index), calendar);

            if(msg == null)
            {
                addToHistory(book, calendar);
                books.remove(index);
                return null;
            }
            else
            {
                return msg;
            }
        }


    }

    private String addToHistory(Book book, Calendar returnDate)
    {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://teamthree.cejfxkzyperf.us-west-2.rds.amazonaws.com:1433;" +
                    "databaseName=Project1", "admin", "Project1");
        }
        catch(Exception e1) {
            JOptionPane.showMessageDialog(null, "Could not connect to the Database.");
        }

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO Orders ([Users ID], [Username], [Book Category], [Book Name], [Quantity], [Price], [Date Due]) VALUES ('"
                    + Main.user.getID() + "','" + Main.user.getUserName() + "','" + Book.convertGenreToString(book.getCategory()) + "','" + book.getName() + "','" + 1 + "','" + "4.99" + "','" + returnDate.getTime().toString() + "')");

        }
        catch(Exception e)
        {

        }

        return null;
    }
}
