package project1;

public class Student extends Account
{
	private String Status;
    private int booksRented;
    private final int MAX_BOOKS_RENT = 1;
    private Book[] rentedBooks;

    public Student() {
    	
    }
    
    public Student(String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String PayPal)
    {
        super(firstName, middleInitial, lastName, emailAddress, userName, Password, PayPal);
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}  
}
