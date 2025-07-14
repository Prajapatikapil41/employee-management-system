# Employee Management System (Java + Spring Boot + MySQL + HTML/CSS/JS)  
A full‑stack CRUD web application to manage employee records with features like add, view, update, and delete. Responsive frontend paired with a Spring Boot REST API and MySQL backend.

Codveda Internship Project – Level 2 Task 1

---

## 🔧 Features / User Stories

- I can add a new employee with details: Name, Emp ID, Email, Phone, Status, Address, Department, Job, Salary.  
- I can view all employees in a modern, sortable table.  
- I can edit existing employee details inline via an “Edit” button.  
- I can delete employees with confirmation.  
- I get real‑time updates without page reloads.  

---

## 🖼️ Screenshots
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(153).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(154).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(155).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(156).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(157).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(158).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(159).png)
   ![Form Screenshot](https://github.com/Prajapatikapil41/employee-management-system/blob/main/Images/Screenshot%20(160).png)


---

## 🖥️ System Design

> Client–Server architecture:

- **Client Side**: HTML5, CSS3 (modern UI), Vanilla JavaScript (fetch API)  
- **Server Side**: Java 17, Spring Boot 3.x, Spring Data JPA  
- **Database**: MySQL 8.x  

```text
[Browser] ←–fetch→ [Spring Boot REST API] ←–JPA→ [MySQL database]
````

---

## 🗂️ Project Structure

```
EmployeeManagementSystem/
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/employee_management/
│   │       │       ├── controller/
│   │       │       │   └── EmployeeController.java
│   │       │       ├── model/
│   │       │       │   └── Employee.java
│   │       │       ├── repository/
│   │       │       │   └── EmployeeRepository.java
│   │       │       ├── service/
│   │       │       │   └── EmployeeService.java
│   │       │       └── EmployeeManagementSystemApplication.java
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── README.md
```

---

## 🧰 Technology Stack

| Layer        | Stack Components                                              |
| ------------ | ------------------------------------------------------------- |
| **Frontend** | HTML5, CSS3, JavaScript (ES6 Fetch API)                       |
| **Backend**  | Java 17, Spring Boot 3.x, Spring Data JPA, Lombok             |
| **Database** | MySQL 8.x (Workbench)                                         |
| **Tools**    | VS Code, Git, GitHub, Live Server (or any static file server) |

---

## ▶️ Steps to Run Application

### 1. Start MySQL

* Create database:

  ```sql
  CREATE DATABASE employeedb;
  ```
* Note your username/password.

### 2. Run Backend

```bash
cd backend
# configure src/main/resources/application.properties:
# spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
# spring.datasource.username=your_user
# spring.datasource.password=your_pass
mvn spring-boot:run
```

> Default port: 8080

### 3. Serve Frontend

```bash
cd frontend
# Option A: Use VS Code Live Server
# Option B: Simple Python HTTP server
python -m http.server 5500
```

> Then browse to `http://localhost:5500`

---

## 🔍 How It Works

1. User submits add/edit form → JavaScript gathers inputs.
2. `fetch()` sends POST/PUT to `http://localhost:8080/api/employees`.
3. Spring Boot controller persists via JPA to MySQL.
4. After success, JS reloads table via GET on `/api/employees`.
5. Delete sends DELETE to `/api/employees/{id}` and refreshes list.

---

## 💡 Future Enhancements

* Add search/filter and pagination on the table.
* Implement column‑sorting and live search.
* Convert frontend to React or Vue.js SPA.
* Secure APIs with JWT authentication.
* Deploy frontend to Netlify and backend to Heroku/AWS.

---

## 👨‍💻 Author

| Name                | GitHub                                                  | LinkedIn                                                                  | E‑Mail                                                              |
| ------------------- | ------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------- |
| **Kapil Prajapati** | [Prajapatikapil41](https://github.com/Prajapatikapil41) | [kapil‑prajapati](https://www.linkedin.com/in/kapil-prajapati-7ba4b51b7/) | [kapilprajapati0403@gmail.com](mailto:kapilprajapati0403@gmail.com) |

