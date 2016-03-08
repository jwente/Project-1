package project1;

public class Student extends Account
{
    private int booksRented;

    private final int MAX_BOOKS_RENT = 1;

    public Student(String firstName, char middleInitial, String lastName, String emailAddress)
    {
        super(firstName, middleInitial, lastName, emailAddress);
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
