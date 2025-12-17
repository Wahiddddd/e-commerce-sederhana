## 📌 Project Overview

E-Commerce Sederhana is a backend REST API built with Spring Boot to manage users, products, orders, and payments.
This project is created as part of backend development practice and portfolio showcase.

## 🚀 Features

* User Management (CRUD)
* Product Management (CRUD)
* Order & Order Item Management
* Payment Simulation
* RESTful API Architecture
* Layered Architecture (Controller, Service, Repository)

## 🧪 API Documentation

### 👤 User

| Method | Endpoint                       | Description      |
| ------ | ------------------------------ | ---------------- |
| POST   | `/users`                       | Create new user  |
| POST   | `/users/{id}/roles?role=BUYER` | Add role to user |

---

### 📦 Product

| Method | Endpoint                        | Description        |
| ------ | ------------------------------- | ------------------ |
| POST   | `/products?sellerId={sellerId}` | Create new product |

---

### 🛒 Order

| Method | Endpoint                    | Description       |
| ------ | --------------------------- | ----------------- |
| POST   | `/orders?buyerId={buyerId}` | Create new order  |
| GET    | `/orders/{orderId}/items`   | Get order items   |
| POST   | `/orders/{orderId}/items`   | Add item to order |

**Request Body – Add Item**

```json
{
  "productId": 1,
  "quantity": 2
}
```

---

### 💳 Payment

| Method | Endpoint                                            | Description |
| ------ | --------------------------------------------------- | ----------- |
| POST   | `/payments/pay?buyerId={buyerId}&orderId={orderId}` | Pay order   |


## 🖼️ Project Status

🛠️ This project is under active development. New features and improvements are continuously added.

## 📬 Contact

* GitHub: https://github.com/Wahiddddd
* Email: firgiyantowahid@gmail.com
* LinkedIn: https://www.linkedin.com/in/wahid-firgiyanto-ba1a09297/

🧪 All APIs can be tested using Postman.
