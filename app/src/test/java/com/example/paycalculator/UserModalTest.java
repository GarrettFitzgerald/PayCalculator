package com.example.paycalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserModalTest
{
    int id;
    String username;
    String firstName;
    String lastName ;
    String password;
    int jobTitle;
    int payGrade;
    int kiwisaver;
    int union;
    int studentLoan;
    int parkingCard;

    UserModal testObj;

    @Before
    public void setUp() throws Exception
    {
        id = 0;
        username = "fitgar";
        firstName = "Garrett";
        lastName = "Fitzgerald";
        password = "q1w2e3";
        jobTitle = 0;
        payGrade = 0;
        kiwisaver = 0;
        union = 0;
        studentLoan = 0;
        parkingCard = 0;

        testObj = new UserModal(id, username, firstName, lastName, password, jobTitle, payGrade,
                kiwisaver, union, studentLoan, parkingCard);
    }

    @After
    public void tearDown() throws Exception
    {
        testObj = null;
    }

    @Test
    public void getId()
    {
        assertEquals( id, testObj.getId() );
    }

    @Test
    public void getUsername()
    {
        assertEquals( username, testObj.getUsername() );
    }

    @Test
    public void getFirstName()
    {
        assertEquals( firstName, testObj.getFirstName() );
    }

    @Test
    public void getlastName()
    {
        assertEquals( lastName, testObj.getlastName() );
    }

    @Test
    public void getPassword()
    {
        assertEquals( password, testObj.getPassword() );
    }

    @Test
    public void getJobTitle()
    {
        assertEquals( jobTitle, testObj.getJobTitle() );
    }

    @Test
    public void getPaygrade()
    {
        assertEquals( payGrade, testObj.getPaygrade() );
    }

    @Test
    public void getKiwisaver()
    {
        assertEquals( kiwisaver, testObj.getKiwisaver() );
    }

    @Test
    public void getUnion()
    {
        assertEquals( union, testObj.getUnion() );
    }

    @Test
    public void getStudentLoan()
    {
        assertEquals( studentLoan, testObj.getStudentLoan() );
    }

    @Test
    public void getParkingCard()
    {
        assertEquals( parkingCard, testObj.getParkingCard() );
    }
}