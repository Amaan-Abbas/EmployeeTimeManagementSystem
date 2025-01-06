document.getElementById('loginForm').addEventListener('submit', function (e) {
    e.preventDefault();
  
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const userType = document.getElementById('userType').value;
  
    // Simulated authentication (Replace with real authentication logic)
    if (username && password) {
      if (userType === 'employee') {
        window.location.href = 'employee_dashboard.html'; // Redirect to Employee Dashboard
      } else if (userType === 'hr') {
        window.location.href = 'hr_dashboard.html'; // Redirect to HR Manager Dashboard
      }
    } else {
      document.getElementById('loginMessage').textContent = 'Please fill out all fields.';
    }
  });
  