package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){

    }

    public void setEmployee(Employee Employee){
        this.employee = Employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    @Override
    public String toString() {
        return employee.getFirstName() + " " +
                employee.getLastName() + " has " +
                numberOfReports + " people they're leading. ";
    }
}
