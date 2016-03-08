package project1;

public class Faculty extends Account
{
    private int booksRented;

    private final int MAX_BOOKS_RENT = 4;

    public Faculty(String firstName, char middleInitial, String lastName, String emailAddress)
    {
        super(firstName, middleInitial, lastName, emailAddress);

        this.booksRented = 0;
    }

    public boolean rentBook()
    {
        if(booksRented < MAX_BOOKS_RENT)
        {
            this.booksRented++;
            return true;
        }
        else
        {
            return false;
        }
    }
}
