package com.example.paycalculator;

import java.time.LocalDate;

public class PayCycleModal
{
    //Fields
    private int id;
    private int idUser;
    private LocalDate startDate;
    private String weekOne_Monday;
    private String weekOne_Tuesday;
    private String weekOne_Wednesday;
    private String weekOne_Thursday;
    private String weekOne_Friday;
    private String weekOne_Saturday;
    private String weekOne_Sunday;
    private String weekTwo_Monday;
    private String weekTwo_Tuesday;
    private String weekTwo_Wednesday;
    private String weekTwo_Thursday;
    private String weekTwo_Friday;
    private String weekTwo_Saturday;
    private String weekTwo_Sunday;

    //Constructors
    public PayCycleModal()
    {
        this.id = 0;
        this.idUser = 0;
        this.startDate = LocalDate.of(1700, 1, 1);
        this.weekOne_Monday = "----";
        this.weekOne_Tuesday = "----";
        this.weekOne_Wednesday = "----";
        this.weekOne_Thursday = "----";
        this.weekOne_Friday = "----";
        this.weekOne_Saturday = "----";
        this.weekOne_Sunday = "----";
        this.weekTwo_Monday = "----";
        this.weekTwo_Tuesday = "----";
        this.weekTwo_Wednesday = "----";
        this.weekTwo_Thursday = "----";
        this.weekTwo_Friday = "----";
        this.weekTwo_Saturday = "----";
        this.weekTwo_Sunday = "----";
    } // Default Constructor

    public PayCycleModal( int id, int id_user, LocalDate startDate)
    {
        this.id = id;
        this.idUser = id_user;
        this.startDate = startDate;
        this.weekOne_Monday = "----";
        this.weekOne_Tuesday = "----";
        this.weekOne_Wednesday = "----";
        this.weekOne_Thursday = "----";
        this.weekOne_Friday = "----";
        this.weekOne_Saturday = "----";
        this.weekOne_Sunday = "----";
        this.weekTwo_Monday = "----";
        this.weekTwo_Tuesday = "----";
        this.weekTwo_Wednesday = "----";
        this.weekTwo_Thursday = "----";
        this.weekTwo_Friday = "----";
        this.weekTwo_Saturday = "----";
        this.weekTwo_Sunday = "----";
    } // Initializing with Date and IDs

    public PayCycleModal( int id, int idUser, LocalDate startDate, String WeekOne_Monday,
                          String WeekOne_Tuesday, String WeekOne_Wednesday, String WeekOne_Thursday,
                          String WeekOne_Friday, String WeekOne_Saturday, String WeekOne_Sunday,
                          String WeekTwo_Monday,String WeekTwo_Tuesday, String WeekTwo_Wednesday,
                          String WeekTwo_Thursday,String WeekTwo_Friday, String WeekTwo_Saturday,
                          String WeekTwo_Sunday )

    {
        this.id = id;
        this.idUser = idUser;
        this.startDate = startDate;
        this.weekOne_Monday = WeekOne_Monday;
        this.weekOne_Tuesday = WeekOne_Tuesday;
        this.weekOne_Wednesday = WeekOne_Wednesday;
        this.weekOne_Thursday = WeekOne_Thursday;
        this.weekOne_Friday = WeekOne_Friday;
        this.weekOne_Saturday = WeekOne_Saturday;
        this.weekOne_Sunday = WeekOne_Sunday;
        this.weekTwo_Monday = WeekTwo_Monday;
        this.weekTwo_Tuesday = WeekTwo_Tuesday;
        this.weekTwo_Wednesday = WeekTwo_Wednesday;
        this.weekTwo_Thursday = WeekTwo_Thursday;
        this.weekTwo_Friday = WeekTwo_Friday;
        this.weekTwo_Saturday = WeekTwo_Saturday;
        this.weekTwo_Sunday = WeekTwo_Sunday;
    } // Updating the table

    //Properties

    public int getId() { return id; }
    public void setId( int id ){ this.id = id ;}

    public int getIdUser(){ return idUser; }
    public void setIdUser( int idUser ){this.idUser = idUser ;}

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate( LocalDate startDate ){ this.startDate = startDate; }

    public String getWeekOne_Monday(){return weekOne_Monday;}
    public void setWeekOne_Monday(String weekOne_Monday){ this.weekOne_Monday = weekOne_Monday;}

    public String getWeekOne_Tuesday(){return weekOne_Tuesday;}
    public void setWeekOne_Tuesday(String weekOne_Tuesday){ this.weekOne_Tuesday = weekOne_Tuesday;}

    public String getWeekOne_Wednesday(){return weekOne_Wednesday;}
    public void setWeekOne_Wednesday(String weekOne_Wednesday){ this.weekOne_Wednesday = weekOne_Wednesday;}

    public String getWeekOne_Thursday(){return weekOne_Thursday;}
    public void setWeekOne_Thursday(String weekOne_Thursday){ this.weekOne_Thursday = weekOne_Thursday;}

    public String getWeekOne_Friday(){return weekOne_Friday;}
    public void setWeekOne_Friday(String weekOne_Friday){ this.weekOne_Friday = weekOne_Friday;}

    public String getWeekOne_Saturday(){return weekOne_Saturday;}
    public void setWeekOne_Saturday(String weekOne_Saturday){ this.weekOne_Saturday = weekOne_Saturday;}

    public String getWeekOne_Sunday(){return weekOne_Sunday;}
    public void setWeekOne_Sunday(String weekOne_Sunday){ this.weekOne_Sunday = weekOne_Sunday;}

    public String getWeekTwo_Monday(){return weekTwo_Monday;}
    public void setWeekTwo_Monday(String weekTwo_Monday){ this.weekTwo_Monday = weekTwo_Monday;}

    public String getWeekTwo_Tuesday(){return weekTwo_Tuesday;}
    public void setWeekTwo_Tuesday(String weekTwo_Tuesday){ this.weekTwo_Tuesday = weekTwo_Tuesday;}

    public String getWeekTwo_Wednesday(){return weekTwo_Wednesday;}
    public void setWeekTwo_Wednesday(String weekTwo_Wednesday){ this.weekTwo_Wednesday = weekTwo_Wednesday;}

    public String getWeekTwo_Thursday(){return weekTwo_Thursday;}
    public void setWeekTwo_Thursday(String weekTwo_Thursday){ this.weekTwo_Thursday = weekTwo_Thursday;}

    public String getWeekTwo_Friday(){return weekTwo_Friday;}
    public void setWeekTwo_Friday(String weekTwo_Friday){ this.weekTwo_Friday = weekTwo_Friday;}

    public String getWeekTwo_Saturday(){return weekTwo_Saturday;}
    public void setWeekTwo_Saturday(String weekTwo_Saturday){ this.weekTwo_Saturday = weekTwo_Saturday;}

    public String getWeekTwo_Sunday(){return weekTwo_Sunday;}
    public void setWeekTwo_Sunday(String weekTwo_Sunday){ this.weekTwo_Sunday = weekTwo_Sunday;}


    //Methods
}
