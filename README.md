# 💰 WealthWise - Personal Gold Asset & Expense Tracker

**WealthWise** is a Spring Boot-based web application that helps users track their personal **gold investments** and **expenses**. It calculates real-time profit/loss by fetching the **latest 22-carat gold rate** live from Goodreturns.in.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🧾 Add, View, and Delete Expenses
- 🪙 Add, View, and Delete Gold Assets
- 📈 Calculates:
  - Total grams of gold
  - Total investment made
  - Real-time gold value
  - Profit/Loss based on current gold rate
- 🌐 Scrapes real-time **22-carat gold rate** from Coimbatore (Goodreturns)
- 📅 Tracks purchase date for each gold entry
- 💜 Clean, responsive UI with a purple theme

---

## 📸 Screenshots

### 🔐 Login Page  
![Login Page](https://github.com/user-attachments/assets/8f1529a5-a02d-422d-9f52-bed1fedf5229)

### 🪙 Assets Page  
![Assets Page](https://github.com/user-attachments/assets/299eee55-3d70-4f6b-9af7-cd48e8a953fe)

### 🧾 Expense Tracker  
![Expense Tracker](https://github.com/user-attachments/assets/6e337cfb-89ea-40bc-8319-f63675f0b012)

---

## 🧪 How to Run

1. **Clone the repo:**
   ```bash
   git clone https://github.com/RoshaanJs/WealthWise.git
   cd WealthWise
   ```

2. **Set up MySQL database:**
   - Create a database named `wealthwise`
   - Update your DB credentials in `application.properties`

3. **Run the application:**
   - Open in Eclipse or IntelliJ
   - Run as **Spring Boot App**

4. **Access on browser:**
   ```
   http://localhost:8080/
   ```

---

## ⚙️ Technologies Used

- **Java** (Core + Spring Boot)
- **MySQL** (Database)
- **JSP** + JSTL (Frontend)
- **Hibernate / Spring Data JPA**
- **JSoup** (For live gold rate web scraping)
- **HTML/CSS** (UI styling)

---

## 📂 Project Structure

```
src/
├── controller/
│   └── AssetController.java
│   └── ExpenseController.java
│   └── GoldRateController.java
├── service/
│   └── GoldRateService.java
│   └── AssetService.java
├── entity/
│   └── Asset.java
│   └── Expense.java
│   └── GoldRate.java
│   └── NewUser.java
├── repository/
│   └── AssetRepository.java
│   └── GoldRateRepository.java
│   └── ExpenseRepository.java
├── resources/
│   └── application.properties
│   └── static/
│   └── templates/
```

---

## 🙋‍♂️ Author

Made with 💜 by **Roshaan JS**

- 📧 roshaan.js2002@gmail.com
- 🌐 [GitHub](https://github.com/RoshaanJs)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
