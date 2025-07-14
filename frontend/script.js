window.addEventListener("DOMContentLoaded", () => {
  const API_URL = "http://localhost:8080/api/employees";

  const jobsByDepartment = {
    IT: ["Developer", "QA Engineer", "System Admin", "DevOps Engineer"],
    HR: ["Recruiter", "HR Manager", "Training Specialist"],
    Finance: ["Accountant", "Financial Analyst", "Auditor"],
    Marketing: ["Content Writer", "SEO Specialist", "Social Media Manager"],
  };

  const departmentSelect = document.getElementById("department");
  const jobSelect = document.getElementById("job");

  departmentSelect.addEventListener("change", () => {
    const dept = departmentSelect.value;
    jobSelect.innerHTML = '<option value="">Select Job</option>';
    if (jobsByDepartment[dept]) {
      jobsByDepartment[dept].forEach((job) => {
        const option = document.createElement("option");
        option.value = job;
        option.textContent = job;
        jobSelect.appendChild(option);
      });
    }
  });

  let isUpdate = false;
  let updateEmpId = null;

  document.getElementById("employeeForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const emp = {
      name: document.getElementById("empName").value,
      empCode: document.getElementById("empCode").value,
      email: document.getElementById("email").value,
      phone: document.getElementById("phone").value,
      workingStatus: document.getElementById("workingStatus").checked,
      address: document.getElementById("empAddress").value,
      department: departmentSelect.value,
      job: jobSelect.value,
      salary: parseFloat(document.getElementById("salary").value),
    };

    if (isUpdate) {
      fetch(`${API_URL}/${updateEmpId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(emp),
      })
        .then((res) => {
          if (!res.ok) throw new Error("Update failed");
          return res.json();
        })
        .then(() => {
          alert("Employee updated successfully!");
          resetForm();
          loadEmployees();
        })
        .catch((err) => alert(err.message));
    } else {
      fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(emp),
      })
        .then((res) => {
          if (!res.ok) throw new Error("Add employee failed");
          return res.json();
        })
        .then(() => {
          alert("Employee added successfully!");
          resetForm();
          loadEmployees();
        })
        .catch((err) => alert(err.message));
    }
  });

  function loadEmployees() {
    fetch(API_URL)
      .then((res) => res.json())
      .then((data) => {
        const rows = data
          .map((emp) => {
            return `
          <tr>
            <td>${emp.name}</td>
            <td>${emp.empCode}</td>
            <td>${emp.email}</td>
            <td>${emp.phone}</td>
            <td>${emp.workingStatus ? "Working" : "Not Working"}</td>
            <td>${emp.address}</td>
            <td>${emp.department}</td>
            <td>${emp.job}</td>
            <td>${emp.salary.toFixed(2)}</td>
            <td>
              <button onclick='editEmp(${JSON.stringify(emp)})'>Edit</button>
              <button onclick='deleteEmp(${emp.id})'>Delete</button>
            </td>
          </tr>
        `;
          })
          .join("");
        document.getElementById("employeeList").innerHTML = rows;
      });
  }

  window.editEmp = function (emp) {
    updateEmpId = emp.id;
    isUpdate = true;
    document.getElementById("empName").value = emp.name;
    document.getElementById("empCode").value = emp.empCode;
    document.getElementById("email").value = emp.email;
    document.getElementById("phone").value = emp.phone;
    document.getElementById("workingStatus").checked = emp.workingStatus;
    document.getElementById("empAddress").value = emp.address;
    document.getElementById("department").value = emp.department;

    // Trigger change to fill job dropdown
    const event = new Event("change");
    departmentSelect.dispatchEvent(event);

    document.getElementById("job").value = emp.job;
    document.getElementById("salary").value = emp.salary;

    document.getElementById("formBtn").textContent = "Update Employee";
  };

  window.deleteEmp = function (id) {
    if (!confirm("Are you sure you want to delete this employee?")) return;

    fetch(`${API_URL}/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (!res.ok) throw new Error("Delete failed");
        loadEmployees();
      })
      .catch((err) => alert(err.message));
  };

  function resetForm() {
    document.getElementById("employeeForm").reset();
    isUpdate = false;
    updateEmpId = null;
    document.getElementById("formBtn").textContent = "Add Employee";
  }

  loadEmployees();
});
