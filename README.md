# 🛒 E-Commerce Sederhana — Backend REST API
## 🎯 Problem Statement

Pada banyak bisnis kecil hingga menengah, proses jual beli sering kali masih dilakukan secara manual atau menggunakan sistem yang terpisah-pisah. Hal ini menyebabkan kesulitan dalam mengelola data produk, transaksi, serta hak akses pengguna (penjual dan pembeli).

Sistem backend ini dibuat untuk mensimulasikan bagaimana sebuah platform e-commerce dapat:
* Mengelola data pengguna, produk, dan transaksi secara terpusat
* Menjaga keamanan akses pengguna
* Memberikan alur transaksi yang jelas dan terstruktur

Dengan adanya backend ini, proses bisnis menjadi lebih rapi, aman, dan mudah dikembangkan di masa depan.

## ⚙️ Gambaran Umum Cara Kerja Sistem

Secara sederhana, sistem bekerja sebagai berikut:

1. User mendaftar dan login
* Sistem memverifikasi email dan password
* Jika valid, user akan mendapatkan JWT Token

2. JWT digunakan untuk mengakses fitur
* Token dikirim di setiap request melalui header
* Sistem memastikan user sudah login sebelum mengakses fitur tertentu

3. Seller dapat menambahkan produk
* Produk disimpan ke database
* Hanya user dengan role seller yang dapat melakukan aksi ini

4. Buyer membuat order dan menambahkan item
* Sistem menghitung subtotal dan total harga
* Stock produk diperbarui secara otomatis

5. Payment diproses
* Sistem memvalidasi kepemilikan order
* Status order diubah menjadi PAID

Semua proses ini dilakukan melalui REST API dan dapat diakses oleh frontend atau aplikasi lain.

## 💼 Manfaat Sistem

Untuk Pengguna:
* Proses transaksi lebih aman dengan autentikasi
* Alur pemesanan jelas dan terkontrol
* Mudah digunakan melalui API

Untuk Bisnis
* Struktur backend siap dikembangkan
* Mudah integrasi dengan frontend atau mobile app
* Kontrol akses berbasis role (ADMIN, SELLER, BUYER)

## ⚖️ Technical Decisions & Trade-Offs
Beberapa keputusan teknis dalam project ini dibuat dengan pertimbangan pembelajaran dan kesederhanaan:
* Menggunakan JDBC + SQL manual
  * Memberikan kontrol penuh terhadap query
  * Membantu memahami alur data dan transaksi database
  * Trade-off: lebih banyak boilerplate dibandingkan JPA
* Menggunakan JWT untuk authentication
  * Stateless dan cocok untuk REST API
  * Mudah diintegrasikan dengan frontend
  * Trade-off: belum ada mekanisme token revocation
* Role disimpan di tabel terpisah
  * Memungkinkan satu user memiliki banyak role
  * Lebih fleksibel untuk pengembangan lanjutan

Keputusan ini dipilih agar sistem tetap mudah dipahami, terkontrol, dan scalable untuk skenario real-world sederhana.

# 🔧 DOKUMENTASI TEKNIS
## 📐 Pengantar Teknis Sistem
* Bahasa: Java
* Framework: Spring Boot
* Database: MySQL
* Arsitektur: Layered Architecture
* Autentikasi: JWT (JSON Web Token)

Struktur layer: 
Controller → Service → Repository → Database

## 🧠 Analisis Kebutuhan & Perancangan Backend

Kebutuhan Fungsional: 
* Autentikasi & otorisasi user
* Manajemen produk
* Manajemen order & item
* Simulasi pembayaran

Kebutuhan Non-Fungsional
* Keamanan dasar
* Struktur kode rapi
* Mudah diuji dan dikembangkan

Perancangan dilakukan dengan memisahkan:
* Entity → representasi database
* DTO → komunikasi API
* Service → logika bisnis

## 🗄️ Pengelolaan Data
* Menggunakan JDBC Template
* Query SQL ditulis secara eksplisit
* DTO digunakan untuk memisahkan entity dan request API
* Relasi data dikelola di level service

Pendekatan ini memberikan kontrol penuh terhadap query dan performa database.

## 🔐 Keamanan Dasar
Keamanan diterapkan melalui:
* JWT Authentication
* Proteksi endpoint menggunakan Spring Security
* Role-based authorization (ADMIN, SELLER, BUYER)
* Token wajib disertakan di setiap request terproteksi

Hal ini mencegah akses tidak sah ke resource sistem.

## 🧪 Quality Control & Testing
* Seluruh API diuji menggunakan Postman
* Pengujian mencakup:
  * Autentikasi
  * Akses endpoint
  * Validasi alur bisnis
* Struktur kode dibuat konsisten dan mudah dibaca

## 📡 API Examples

### 🔐 Authentication – Login

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/auth/login` | Authenticate user and generate JWT |

**Request Body**
`Json: 
{
  "email": "user@mail.com",
  "password": "password123"
}`

**Response Body**
`{
  "token": "JWT_TOKEN_HERE"
}`

### 📦 Product – Create Product (Seller)

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/products` | Create New Product |

**Header**
Authorization: Bearer JWT_TOKEN_HERE

**Request Body**
`{
  "name": "Laptop",
  "price": 15000000,
  "stock": 5
}`

### 🛒 Order – Create Order

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/orders` | Create New Order |

**Header**
Authorization: Bearer JWT_TOKEN_HERE

### 🛒 Order – Add Item

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/orders/{orderId}/items` | Add Item to Order |

**Request Body**
`{
  "productId": 1,
  "quantity": 2
}`

### 💳 Payment – Pay Order
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/payments/pay/{orderId}` | Process Payment |

## 📊 Evaluasi Teknis & Finalisasi Portofolio
Kelebihan
* Struktur backend jelas
* Implementasi JWT
* Pemisahan layer yang rapi
* Siap dikembangkan lebih lanjut

Potensi Pengembangan
* Global Exception Handler
* Pagination & filtering
* Dokumentasi OpenAPI (Swagger)
* Integrasi frontend

## 📬 Contact

* GitHub: https://github.com/Wahiddddd
* Email: firgiyantowahid@gmail.com
* LinkedIn: https://www.linkedin.com/in/wahid-firgiyanto-ba1a09297/

### 🧪 Seluruh endpoint dapat diuji menggunakan Postman dengan JWT Token.
