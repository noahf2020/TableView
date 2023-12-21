package com.example.tableview;

public class Activity {
    private String Name;
    private int Grade;
    private int Sports;
    private double GPA;
    private boolean Standing;

    public Activity(String Name, int Grade, int Sports, double GPA, boolean Standing){
        this.Name = Name;
        this.Grade = Grade;
        this.Sports = Sports;
        this.GPA = GPA;
        this.Standing = Standing;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public int getGrade() {
        return this.Grade;
    }
    public void setGrade(int grade) {
        this.Grade = grade;
    }
    public int getSports(){
        return this.Sports;
    }
    public void setSports(int sports){
        this.Sports = sports;
    }
    public double getGPA(){
        return this.GPA;
    }

    public void setGPA(double gpa){
        this.GPA = gpa;
    }

    public boolean getStanding(){
        return this.Standing;
    }

    public void setStanding(boolean standing){
        this.Standing = standing;
    }

}
