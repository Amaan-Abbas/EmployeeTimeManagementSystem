package org.model;
import java.time.LocalDate;

public class WorkHours {
    private int id;
    private int employeeId;
    private LocalDate date;
    private double hoursWorked;

    // Constructor, Getters, and Setters
    public WorkHours(int id, int employeeId, LocalDate date, double hoursWorked) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
}
