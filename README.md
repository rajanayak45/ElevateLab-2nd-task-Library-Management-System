# 📚 Library Management System (Java OOP + File Storage)

## 📌 Overview
A **Java-based mini project** that manages books and users in a library using **Object-Oriented Programming (OOP)** principles.  
Features include:
- Displaying books
- Issuing books to users
- Returning books
- Saving and loading data using **file serialization** (persistence)

## 🛠 Features
- **OOP Concepts Used**: Classes, Objects, Encapsulation, Methods
- **Data Persistence**: Saves library data in a `.dat` file
- **Menu-Driven Console UI**
- **Automatic User Registration** *(optional upgrade)*

## ⚙️ How It Works
1. **Books** have:
   - ID
   - Title
   - Author
   - Availability status (Issued/Available)
2. **Users** have:
   - User ID
   - Name
3. **Library**:
   - Stores a list of books and users
   - Handles book issuing and returning
4. **File Storage**:
   - Data is saved automatically to `libraryData.dat`
   - When restarted, the program loads previous data
