package com.example.paycalculator;

public class UserModal
{
    // Fields
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private int jobTitle;
    private int payGrade;
    private int kiwisaver;
    private int union;
    private int studentLoan;
    private int parkingCard;

    // Constructors
    public UserModal() // Constructor
    {
        this.id = 0;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.jobTitle = 0;
        this.payGrade = 0;
        this.kiwisaver = 0;
        this.union = 0;
        this.studentLoan = 0;
        this.parkingCard = 0;
    }

    public UserModal( int id, String username, String firstName, String lastName, String password ) // Constructor used when making a new account
    {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.jobTitle = 0;
        this.payGrade = 0;
        this.kiwisaver = 0;
        this.union = 0;
        this.studentLoan = 0;
        this.parkingCard = 0;
    }

    public UserModal( int id, String firstName, String lastName, int jobTitle, int payGrade, int kiwisaver,
                      int union, int studentLoan, int parkingCard)
    {
        this.id = id;
        this.username = "";
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = "";
        this.jobTitle = jobTitle;
        this.payGrade = payGrade;
        this.kiwisaver = kiwisaver;
        this.union = union;
        this.studentLoan = studentLoan;
        this.parkingCard = parkingCard;
    } //used for information screen

    //Properties
    public int getId() {
        return id;
    }
    public void setId( int id )
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String firstName) { this.firstName = firstName; }

    public String getlastName() {
        return lastName;
    }
    public void setlastName( String lastName) { this.lastName = lastName; }

    public String getPassword() {
        return password;
    }
    public void setPassword( String password) { this.password = password; }

    public int getJobTitle(){return jobTitle; }
    public void setJobTitle( int jobTitle){this.jobTitle = jobTitle; }

    public int getPaygrade(){return payGrade; }
    public void setPaygrade(int paygrade) {this.payGrade = paygrade; }

    public int getKiwisaver(){return kiwisaver;}
    public void setKiwisaver( int kiwisaver){this.kiwisaver = kiwisaver;}

    public int getUnion(){return union;}
    public void setUnion( int union ){this.union = union;}

    public int getStudentLoan(){return studentLoan;}
    public void setStudentLoan( int studentLoan ){this.studentLoan = studentLoan; }

    public int getParkingCard(){return parkingCard;}
    public void setParkingCard( int parkingCard ){this.parkingCard = parkingCard; }

    //Methods
}
