package project1;

public class Faculty extends Account
{
    private int booksRented;

    private final int MAX_BOOKS_RENT = 4;

    private Book[] rentedBooks;

    public Faculty(String firstName, char middleInitial, String lastName, String emailAddress, String userID)
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
