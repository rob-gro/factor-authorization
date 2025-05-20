# Factor Authorization

Factor Authorization is a simple Spring Boot application that demonstrates role-based access control using Spring Security. It allows users to log in and access specific views depending on their assigned roles: `ADMIN`, `USER`, or general public. The project is ideal as a starting point for applications requiring basic authentication and role management.

## ✨ Features

- ✅ Role-based access control with Spring Security
- 👥 Three views: public (`/hello`), user (`/user`), admin (`/admin`)
- 🔒 Secure password storage with BCrypt hashing
- 📄 Thymeleaf templates for basic front-end
- 🧪 H2 in-memory database for easy testing
- ⚙️ Predefined roles and users loaded at startup
- 🔐 Custom UserDetailsService implementation

## 🔧 Technologies Used

- Java 11
- Spring Boot 2.5.5
- Spring Security
- Thymeleaf
- H2 Database
- Maven

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/factor-authorization.git
   cd factor-authorization
