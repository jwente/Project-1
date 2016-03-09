package project1;

public class Student extends Account
{
    private int booksRented;

    private final int MAX_BOOKS_RENT = 1;

    private Book[] rentedBooks;

    public Student(String firstName, char middleInitial, String lastName, String emailAddress, String userID)
    {
        super(firstName, middleInitial, lastName, emailAddress, userID);
        this.rentedBooks = new Book[MAX_BOOKS_RENT];
        this.booksRented = 0;
    }

    public int getBooksRented()
    {
        return this.booksRented;
    }

    public boolean rentBook(Book book)
    {
        if(booksRented < MAX_BOOKS_RENT)
        {
            this.rentedBooks[this.booksRented] = book;
            this.booksRented++;
            return true;
        }
        else
        {
            return false;
        }
    }
}
