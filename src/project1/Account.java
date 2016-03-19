package project1;

public class Account
{
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String Password;
    private String PayPal;

    public Account() {
    	
    }
    
    public Account(String firstName, String middleInitial, String lastName, String emailAddress, String userName, String Password, String payPal) {
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setUserName(userName);
        setPassword(Password);
        setPayPal(payPal);
    }


	public String getPayPal() {
		return PayPal;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setPayPal(String payPal) {
		PayPal = payPal;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
