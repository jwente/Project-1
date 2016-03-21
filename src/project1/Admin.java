package project1;

public class Admin extends Account
{

    public Admin(String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String PayPal)
    {
        super(1, firstName, middleInitial, lastName, emailAddress, userName, Password, PayPal, "Admin");
    }

    public String getHistoryForAccountByName(String name)
    {
        //i'll get to it eventually
        return null;
    }
}
