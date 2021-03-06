package project1;

import java.util.Calendar;

public class Student extends Account
{
	private String Status;
    private int booksRented;
    private final int MAX_BOOKS_RENT = 1;
    private Book[] rentedBooks;
    private String[] returnDates;


    public Student(int id, String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String PayPal)
    {
        super(id, firstName, middleInitial, lastName, emailAddress, userName, Password, PayPal, "Student");
        this.Status = "Student";
        this.rentedBooks = new Book[MAX_BOOKS_RENT];
        this.returnDates = new String[MAX_BOOKS_RENT];
        this.booksRented = 0;
    }

    public int getBooksRented()
    {
        return this.booksRented;
    }

    public String rentBook(Book book, Calendar returnDate)
    {
        if(booksRented < MAX_BOOKS_RENT)
        {
            this.rentedBooks[this.booksRented] = book;
            this.returnDates[this.booksRented] = returnDate.getTime().toString();
            this.booksRented++;
            return null;
        }
        else
        {
            return getUserName() + " has already checked out 1 book!";
        }
    }

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}  
}
