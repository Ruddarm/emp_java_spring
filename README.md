# 🌊 Glaciersoft Employee Service

A simple **Spring Boot REST API** to manage employees — including CRUD operations, salary updates, and analytical queries such as average salary per department and highest-paid employee.

---

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3.5**
- **Spring Web**
- **Lombok**
- **MapStruct** (for DTO ↔ Entity mapping)
- **In-Memory List** (acts as database — lightweight, no external DB needed)
- **Maven**

---

## ⚙️ Features

✅ Create a new employee  
✅ Get employee by ID  
✅ Get all employees  
✅ Update salary by ID  
✅ Delete employee by ID  
✅ Get average salary per department  
✅ Get highest-paid employee  
✅ Get employees earning above the average  

---

## 🏗️ Project Structure
src/main/java/com/glaciersoft/emp/galciersoft_employee_service/
│
├── controllers/ # REST API controllers
├── dtos/ # Data Transfer Objects
├── exceptions/ # Custom exception classes + global handler
├── mapper/ # MapStruct mappers
├── model/ # Core domain models
└── service/ # Business logic & data management


---

## ⚡️ API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/employee` | Create a new employee |
| `GET` | `/employee/{id}` | Get employee by ID |
| `GET` | `/employee/all` | List all employees |
| `PUT` | `/employee/update-salary?id={id}&salary={salary}` | Update employee salary |
| `DELETE` | `/employee/{id}` | Delete employee by ID |
| `GET` | `/employee/avg-salary` | Average salary per department |
| `GET` | `/employee/highest-salary` | Get highest-paid employee |
| `GET` | `/employee/above-average` | Employees above average salary |

---

## 🧠 Example JSON (for POST `/employee`)

```json
{
  "name": "Ruddarm Mourya",
  "department": "Engineering",
  "salary": 75000
}


# Clone the repo
git clone https://github.com/<your-username>/glaciersoft-employee-service.git
cd glaciersoft-employee-service

# Build the project
mvn clean install

# Run the app
mvn spring-boot:run

