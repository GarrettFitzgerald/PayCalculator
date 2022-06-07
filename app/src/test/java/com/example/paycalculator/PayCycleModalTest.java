package com.example.paycalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class PayCycleModalTest 
{
    int id;
    int idUser;
    LocalDate startDate;
    String weekOne_Monday;
    String weekOne_Tuesday;
    String weekOne_Wednesday;
    String weekOne_Thursday;
    String weekOne_Friday;
    String weekOne_Saturday;
    String weekOne_Sunday;
    String weekTwo_Monday;
    String weekTwo_Tuesday;
    String weekTwo_Wednesday;
    String weekTwo_Thursday;
    String weekTwo_Friday;
    String weekTwo_Saturday;
    String weekTwo_Sunday;    
    
    PayCycleModal testObj;
    
    @Before
    public void setUp() throws Exception 
    {
        id = 0;
        idUser = 1;
        startDate = LocalDate.now();
        weekOne_Monday = "0730";
        weekOne_Tuesday = "0730";
        weekOne_Wednesday = "0730";
        weekOne_Thursday = "0730";
        weekOne_Friday = "0730";
        weekOne_Saturday = "0730";
        weekOne_Sunday = "0730";
        weekTwo_Monday = "0730";
        weekTwo_Tuesday = "0730";
        weekTwo_Wednesday = "0730";
        weekTwo_Thursday = "0730";
        weekTwo_Friday = "0730";
        weekTwo_Saturday = "0730";
        weekTwo_Sunday = "0730";

        testObj = new PayCycleModal( id, idUser, startDate, weekOne_Monday, weekOne_Tuesday,
                                        weekOne_Wednesday, weekOne_Thursday, weekOne_Friday,
                                        weekOne_Saturday, weekOne_Sunday, weekTwo_Monday,
                                        weekTwo_Tuesday, weekTwo_Wednesday, weekTwo_Thursday,
                                        weekTwo_Friday, weekTwo_Saturday, weekTwo_Sunday );
    }

    @After
    public void tearDown() throws Exception
    {
        testObj = null;
    }

    @Test
    public void getId()
    {
        assertEquals( id, testObj.getId());
    }

    @Test
    public void getIdUser()
    {
        assertEquals( idUser, testObj.getIdUser());
    }

    @Test
    public void getStartDate()
    {
        assertEquals( startDate, testObj.getStartDate());
    }

    @Test
    public void getWeekOne_Monday()
    {
        assertEquals( weekOne_Monday, testObj.getWeekOne_Monday());
    }

    @Test
    public void getWeekOne_Tuesday()
    {
        assertEquals( weekOne_Tuesday, testObj.getWeekOne_Tuesday());
    }

    @Test
    public void getWeekOne_Wednesday()
    {
        assertEquals( weekOne_Wednesday, testObj.getWeekOne_Wednesday());
    }

    @Test
    public void getWeekOne_Thursday()
    {
        assertEquals( weekOne_Thursday, testObj.getWeekOne_Thursday());
    }

    @Test
    public void getWeekOne_Friday()
    {
        assertEquals( weekOne_Friday, testObj.getWeekOne_Friday());
    }

    @Test
    public void getWeekOne_Saturday()
    {
        assertEquals( weekOne_Saturday, testObj.getWeekOne_Saturday());
    }

    @Test
    public void getWeekOne_Sunday()
    {
        assertEquals( weekOne_Sunday, testObj.getWeekOne_Sunday());
    }

    @Test
    public void getWeekTwo_Monday()
    {
        assertEquals( weekTwo_Monday, testObj.getWeekTwo_Monday());
    }

    @Test
    public void getWeekTwo_Tuesday()
    {
        assertEquals( weekTwo_Tuesday, testObj.getWeekTwo_Tuesday());
    }

    @Test
    public void getWeekTwo_Wednesday()
    {
        assertEquals( weekTwo_Wednesday, testObj.getWeekTwo_Wednesday());
    }

    @Test
    public void getWeekTwo_Thursday()
    {
        assertEquals( weekTwo_Thursday, testObj.getWeekTwo_Thursday());
    }

    @Test
    public void getWeekTwo_Friday()
    {
        assertEquals( weekTwo_Friday, testObj.getWeekTwo_Friday());
    }

    @Test
    public void getWeekTwo_Saturday()
    {
        assertEquals( weekTwo_Saturday, testObj.getWeekTwo_Saturday());
    }

    @Test
    public void getWeekTwo_Sunday()
    {
        assertEquals( weekTwo_Sunday, testObj.getWeekTwo_Sunday());
    }
}