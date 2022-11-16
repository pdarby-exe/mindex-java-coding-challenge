package com.mindex.challenge.data;

import com.mindex.challenge.service.CompensationService;

import java.time.LocalDate;

public class Compensation {

    private String empID;
    private int salary;
    private LocalDate date;

    public Compensation(){

    }

    public String getempID() {
        return empID;
    }

    public void setEempID(String empID) {
        this.empID = empID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "employee=" + empID +
                ", salary=" + salary +
                ", date=" + date +
                '}';
    }
}
