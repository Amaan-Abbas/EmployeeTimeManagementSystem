package org.model;
import java.time.LocalDate;

public class Schedule {
    private int id;
    private int employeeId;
    private LocalDate shiftDate;
    private String shiftHours;

    // Constructor, Getters, and Setters
    public Schedule(int id, int employeeId, LocalDate shiftDate, String shiftHours) {
        this.id = id;
        this.employeeId = employeeId;
        this.shiftDate = shiftDate;
        this.shiftHours = shiftHours;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }

    public String getShiftHours() { return shiftHours; }
    public void setShiftHours(String shiftHours) { this.shiftHours = shiftHours; }
}
