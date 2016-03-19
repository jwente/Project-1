package project1;

import java.util.Calendar;

public class Faculty extends Account
{
    private int booksRented;
    private final int MAX_BOOKS_RENT = 4;
    private Book[] rentedBooks;
    private String[] returnDates;
    private String Status;
    
    public Faculty() {
    	
    }

    public Faculty(String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String PayPal)
    {
        super(firstName, middleInitial, lastName, emailAddress, userName, Password, PayPal);
        this.rentedBooks = new Book[MAX_BOOKS_RENT];

        this.booksRented = 0;
    }

    public int getBooksRented()
    {
        return this.booksRented;
    }

    public boolean rentBook(Book book, Calendar returnDate)
    {
        if(booksRented < MAX_BOOKS_RENT)
        {
            this.rentedBooks[this.booksRented] = book;
            this.returnDates[this.booksRented] = returnDate.getTime().toString();
            this.booksRented++;
            return true;
        }
        else
        {
            return false;
        }
    }

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	} 
}
