// Log Work Hours
document.getElementById('logWorkForm').addEventListener('submit', function (e) {
    e.preventDefault();
  
    const startTime = document.getElementById('startTime').value;
    const endTime = document.getElementById('endTime').value;
  
    if (startTime && endTime) {
      document.getElementById('logWorkMessage').innerText = `Work hours logged: ${startTime} - ${endTime}`;
      this.reset();
    } else {
      document.getElementById('logWorkMessage').innerText = "Please fill out both fields!";
    }
  });
  
  // Request Time Off
  document.getElementById('timeOffForm').addEventListener('submit', function (e) {
    e.preventDefault();
  
    const startDate = document.getElementById('timeOffStart').value;
    const endDate = document.getElementById('timeOffEnd').value;
    const reason = document.getElementById('reason').value;
  
    if (startDate && endDate && reason) {
      document.getElementById('timeOffMessage').innerText = `Time off requested: ${startDate} to ${endDate}. Reason: ${reason}`;
      this.reset();
    } else {
      document.getElementById('timeOffMessage').innerText = "Please fill out all fields!";
    }
  });
  
  // View Schedule
  document.getElementById('viewScheduleBtn').addEventListener('click', function () {
    const sampleSchedule = `
      <ul>
        <li>Monday: 9 AM - 5 PM</li>
        <li>Tuesday: 9 AM - 5 PM</li>
        <li>Wednesday: 9 AM - 5 PM</li>
        <li>Thursday: 9 AM - 5 PM</li>
        <li>Friday: 9 AM - 5 PM</li>
      </ul>`;
    document.getElementById('scheduleDisplay').innerHTML = sampleSchedule;
  });
  