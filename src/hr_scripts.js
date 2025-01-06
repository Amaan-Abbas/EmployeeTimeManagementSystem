document.addEventListener("DOMContentLoaded", () => {
    // Sample time-off requests
    const timeOffRequests = [
      { name: "John Doe", start: "2024-01-10", end: "2024-01-15", reason: "Vacation" },
      { name: "Jane Smith", start: "2024-01-20", end: "2024-01-22", reason: "Family Emergency" },
    ];
  
    const timeTrackingData = [
      { name: "John Doe", date: "2024-01-05", hours: "8" },
      { name: "Jane Smith", date: "2024-01-05", hours: "7" },
    ];
  
    // Populate Time Off Requests Table
    const timeOffTable = document.querySelector("#timeOffRequests tbody");
    timeOffRequests.forEach(request => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${request.name}</td>
        <td>${request.start}</td>
        <td>${request.end}</td>
        <td>${request.reason}</td>
        <td>
          <button class="approve">Approve</button>
          <button class="deny">Deny</button>
        </td>
      `;
      timeOffTable.appendChild(row);
    });
  
    // Populate Time Tracking Table
    const timeTrackingTable = document.querySelector("#timeTracking tbody");
    timeTrackingData.forEach(entry => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${entry.name}</td>
        <td>${entry.date}</td>
        <td>${entry.hours} hrs</td>
        <td><button class="edit">Edit</button></td>
      `;
      timeTrackingTable.appendChild(row);
    });
  
    // Handle Schedule Update Form
    const scheduleForm = document.querySelector("#updateScheduleForm");
    scheduleForm.addEventListener("submit", (event) => {
      event.preventDefault();
      const name = document.querySelector("#employeeName").value;
      const shiftTimes = document.querySelector("#shiftTimes").value;
      document.querySelector("#scheduleMessage").textContent = `Schedule updated for ${name} with shifts: ${shiftTimes}`;
    });
  
    // Handle Report Generation
    const reportForm = document.querySelector("#generateReportForm");
    reportForm.addEventListener("submit", (event) => {
      event.preventDefault();
      const employee = document.querySelector("#reportEmployee").value;
      const dateRange = document.querySelector("#reportDateRange").value;
      document.querySelector("#reportOutput").innerHTML = `
        <h3>Report for ${employee || "All Employees"}</h3>
        <p>Date Range: ${dateRange}</p>
        <p>Generated successfully.</p>
      `;
    });
  });
  