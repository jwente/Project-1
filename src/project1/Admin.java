package project1;

public class Admin extends Account
{
	public Admin() {
		
	}

    public Admin(String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String PayPal)
    {
        super(firstName, middleInitial, lastName, emailAddress, userName, Password, PayPal);
    }

    public String getHistoryForAccountByName(String name)
    {
        //i'll get to it eventually
        return null;
    }
}
