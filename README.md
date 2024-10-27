# Employee Time Management System

## Overview

The Employee Time Management System is designed to help employees log their work hours, request time off, and view their work schedules. 
This system provides a platform for accurate time tracking and effective management of work-life balance.

## User Types

- **HR Manager**: Oversees the time management system, approves time off requests, and generates reports.
- **Employee**: Logs work hours, requests time off, and views work schedules.

## Functionalities

### HR Manager

- **Time Off Management**
  - **Input**: Employee name, dates for time off requests.
  - **Output**: Confirmation message for request approval/denial.
  - **Functionality**: Review and approve or deny time off requests.

- **Schedule Management**
  - **Input**: Shift times, days off for employees.
  - **Output**: Confirmation message for schedule updates.
  - **Functionality**: Manage and update employee schedules.

- **Time Tracking Review**
  - **Input**: Time tracking data.
  - **Output**: Detailed review and correction options.
  - **Functionality**: Review time logs for accuracy and make adjustments.

- **Generate Reports**
  - **Input**: Report parameters (employee, date range).
  - **Output**: Detailed reports on time logs and time off.
  - **Functionality**: Generate comprehensive reports on employee time management.

### Employee

- **Log Work Hours**
  - **Input**: Start time, end time.
  - **Output**: Confirmation message for successful log entry.
  - **Functionality**: Log work hours for accurate tracking.

- **Request Time Off**
  - **Input**: Dates, reason for time off request.
  - **Output**: Confirmation message for request submission.
  - **Functionality**: Submit time off requests and track their status.

- **View Schedule**
  - **Input**: Employee name, date range.
  - **Output**: Display of personal work schedule.
  - **Functionality**: Access personal work schedules.

## Dashboards

### HR Manager Dashboard
- Time Off Management: Table listing time off requests.
- Schedule Management: Table listing employee schedules.
- Time Tracking Review: Summary of time logs with correction options.
- Generate Reports: Graphical representations of time management data.

### Employee Dashboard
- Log Work Hours: Form for entering work hours.
- Request Time Off: Form for submitting time off requests.
- View Schedule: Display of personal work schedule.

## Setup

### Requirements

- **Java JDK** (version 8 or higher)
- **MySQL** (version 5.7 or higher)
- **JDBC Driver** for MySQL
- **IDE** (such as Eclipse or IntelliJ IDEA)

### Database Setup

1. **Create MySQL Database**: 
   - Create a new database for the project.
   - Execute the SQL scripts provided in the `/sql` directory to set up the required tables.

2. **Tables Created**:
   - Employee
   - HR_Manager
   - Time_Off_Request
   - Schedule
   - Work_Hours

### How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/EmployeeTimeManagementSystem.git
