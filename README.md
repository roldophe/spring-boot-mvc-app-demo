# Spring Boot MVC Demo Application

<div align="center">
  <h3>🚀 A Comprehensive Spring Boot MVC Pattern Demonstration</h3>
  <p><strong>Developer: Radom KHOEM</strong></p>
  <p>Educational project showcasing Spring Web MVC fundamentals</p>
</div>

---

## 📋 Table of Contents

1. [About](#-about)
2. [MVC Pattern Overview](#-mvc-pattern-overview)
3. [Spring Web MVC Features](#-spring-web-mvc-features)
4. [Project Structure](#-project-structure)
5. [Technologies Used](#-technologies-used)
6. [Installation & Setup](#-installation--setup)
7. [Usage Guide](#-usage-guide)
8. [API Endpoints](#-api-endpoints)
9. [Screenshots](#-screenshots)
10. [Key Learning Outcomes](#-key-learning-outcomes)
11. [Contributing](#-contributing)
12. [Contact](#-contact)

---

## 🎯 About

This project is a comprehensive demonstration of the **Spring Boot MVC (Model-View-Controller)** architectural pattern. It implements a complete web application for managing company data, showcasing modern web development practices with Spring Boot.

### 🎓 Educational Purpose

This application serves as a learning resource for:
- Understanding the MVC architectural pattern
- Learning Spring Boot web development
- Practicing with Thymeleaf templating
- Implementing CRUD operations
- Working with in-memory data storage

---

## 🏗️ MVC Pattern Overview

### Model-View-Controller Architecture

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│    MODEL    │    │    VIEW     │    │ CONTROLLER  │
│             │    │             │    │             │
│ • Data      │◄──►│ • Templates │◄──►│ • Requests  │
│ • Business  │    │ • UI Logic  │    │ • Responses │
│ • Logic     │    │ • Rendering │    │ • Routing   │
└─────────────┘    └─────────────┘    └─────────────┘
```

### Components in This Project:

- **Model**: `Company.java`, `CompanyDTO.java`, `Sector.java`
- **View**: Thymeleaf templates (`.html` files)
- **Controller**: `CompanyController.java`

---

## 🌐 Spring Web MVC Features

### Core Annotations Demonstrated:

| Annotation | Purpose | Usage in Project |
|------------|---------|-----------------|
| `@Controller` | Mark class as web controller | `CompanyController.java` |
| `@RequestMapping` | Map URLs to methods | Base mapping `/companies` |
| `@GetMapping` | Handle GET requests | List, view, edit forms |
| `@PostMapping` | Handle POST requests | Create, update operations |
| `@PathVariable` | Extract URL parameters | `/{id}` in URLs |
| `@RequestParam` | Extract query parameters | Search functionality |
| `@ModelAttribute` | Bind form data | Form submissions |

### Spring MVC Flow:

```
Request → DispatcherServlet → Controller → Service → Model → View → Response
```

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/tmane/springbootmvcdemo/
│   │   ├── SpringBootMvcDemoApplication.java    # Main application class
│   │   ├── controller/
│   │   │   └── CompanyController.java           # Web layer (Controller)
│   │   ├── service/
│   │   │   ├── CompanyService.java             # Service interface
│   │   │   └── Impl/
│   │   │       └── CompanyServiceImpl.java     # Business logic (Service)
│   │   ├── dto/
│   │   │   └── CompanyDTO.java                 # Data Transfer Object
│   │   ├── model/
│   │   │   └── Company.java                    # Domain model (Model)
│   │   ├── enums/
│   │   │   └── Sector.java                     # Business enums
│   │   └── util/
│   │       └── Constants.java                  # Application constants
│   └── resources/
│       ├── application.properties              # Configuration
│       ├── static/css/
│       │   └── styles.css                      # Custom styling
│       └── templates/                          # View layer (Thymeleaf)
│           ├── template.html                   # Base layout
│           ├── companies/
│           │   ├── companies.html              # List view
│           │   ├── company.html                # Detail view
│           │   ├── AddCompany.html             # Create form
│           │   └── EditCompany.html            # Edit form
│           └── fragments/
│               ├── navbar.html                 # Navigation fragment
│               └── footer.html                 # Footer fragment
```

---

## 🛠️ Technologies Used

### Backend:
- **Spring Boot 3.3.5** - Application framework
- **Spring Web MVC** - Web layer
- **Java 17** - Programming language
- **Maven** - Build tool
- **Lombok** - Boilerplate code reduction

### Frontend:
- **Thymeleaf** - Server-side templating engine
- **Bootstrap 5** - CSS framework
- **Bootstrap Icons** - Icon library
- **HTML5** - Markup language
- **CSS3** - Styling

### Development:
- **In-Memory Storage** - Data persistence (ArrayList)
- **Constructor Injection** - Dependency injection
- **Builder Pattern** - Object creation

---

## 🚀 Installation & Setup

### Prerequisites:
- Java 17 or higher
- Maven 3.6 or higher

### Installation Steps:

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd spring-boot-mvc-app-demo
   ```

2. **Build the project:**
   ```bash
   ./mvnw clean compile
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application:**
   ```
   http://localhost:8080/companies
   ```

---

## 📖 Usage Guide

### Main Features:

1. **View All Companies** - Browse the complete list of companies
2. **Search Companies** - Filter companies by name
3. **Add New Company** - Create new company records
4. **View Company Details** - See detailed information
5. **Edit Company** - Update existing company data
6. **Delete Company** - Remove company records

### Navigation:

- **Home Page**: `http://localhost:8080/companies`
- **Add Company**: Click the ➕ button or navigate to `/companies/new`
- **View Details**: Click "VIEW" button in the company list
- **Edit**: Click the ✏️ icon in company details or list
- **Delete**: Click the 🗑️ icon (with confirmation)

---

## 🔗 API Endpoints

| Method | Endpoint | Description | Parameters |
|--------|----------|-------------|------------|
| `GET` | `/companies` | List all companies | `?keyword=` (optional) |
| `GET` | `/companies/new` | Show add company form | - |
| `POST` | `/companies` | Create new company | Form data |
| `GET` | `/companies/{id}` | Show company details | `id` (path) |
| `GET` | `/companies/{id}/edit` | Show edit form | `id` (path), `?keyword=` (optional) |
| `POST` | `/companies/{id}/update` | Update company | `id` (path), form data |
| `GET` | `/companies/{id}/delete` | Delete company | `id` (path) |

---

## 📸 Screenshots

### Main Dashboard
- Clean, responsive design with Bootstrap 5
- Search functionality with real-time filtering
- Action buttons with intuitive icons

### Company Forms
- Comprehensive form validation
- Sector selection dropdown
- Date picker for foundation date
- Text area for descriptions

### Company Details
- Card-based layout
- Action buttons for quick operations
- Responsive design for all devices

---

## 🎓 Key Learning Outcomes

After studying this project, you will understand:

### Spring Boot Concepts:
- ✅ Spring Boot application structure
- ✅ Auto-configuration features
- ✅ Dependency injection patterns
- ✅ Component scanning

### Spring Web MVC:
- ✅ Controller layer implementation
- ✅ Request mapping strategies
- ✅ Form handling and validation
- ✅ Model and view interaction
- ✅ Redirect patterns (PRG - Post-Redirect-Get)

### Frontend Integration:
- ✅ Thymeleaf templating engine
- ✅ Fragment and layout composition
- ✅ Form binding with `th:object`
- ✅ Conditional rendering
- ✅ Bootstrap integration

### Best Practices:
- ✅ Separation of concerns
- ✅ Service layer pattern
- ✅ DTO pattern implementation
- ✅ Constructor-based dependency injection
- ✅ Constants usage for maintainability

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

---

## 📞 Contact

**Developer**: Radom KHOEM  
**Project**: Spring Boot MVC Demo Application  
**Purpose**: Educational demonstration of Spring Web MVC patterns

---

<div align="center">
  <h3>🌟 Thank you for exploring this Spring Boot MVC demonstration!</h3>
  <p>Happy coding! 🚀</p>
</div>

---

*Last updated: July 3, 2025*
‣灳楲杮戭潯⵴癭ⵣ灡⵰敤潭�