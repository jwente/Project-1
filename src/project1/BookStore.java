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
        int index = books.indexOf(searchByName(bookName));

        if(faculty.rentBook(books.get(index)))
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
        int index = books.indexOf(searchByName(bookName));

        if(student.rentBook(books.get(index)))
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
