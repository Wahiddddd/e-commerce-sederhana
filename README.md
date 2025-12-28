# 🛒 E-Commerce Sederhana — Backend REST API
## 🎯 Latar Belakang & Alasan Solusi Dibuat

Dalam proses digitalisasi bisnis, sistem e-commerce membutuhkan backend yang mampu mengelola pengguna, produk, pesanan, dan pembayaran secara terstruktur dan aman.

Project E-Commerce Sederhana dibuat untuk menjawab kebutuhan tersebut dengan tujuan:
* Mensimulasikan alur bisnis e-commerce secara nyata
* Melatih penerapan Backend Development menggunakan arsitektur yang baik
* Menyediakan API yang aman dan mudah dikembangkan

## ⚙️ Gambaran Umum Cara Kerja Sistem

Secara sederhana, sistem bekerja sebagai berikut:

1. User melakukan registrasi dan login
2. Sistem memberikan JWT Token sebagai identitas akses
3. User dengan role tertentu dapat:
   * Seller → membuat produk
   * Buyer → membuat order, menambahkan item, dan melakukan pembayaran
4. Semua proses dilakukan melalui REST API
5. Data disimpan dan dikelola di database secara terstruktur

## 💼 Manfaat Sistem

Untuk Pengguna:
* Proses transaksi lebih aman dengan autentikasi
* Alur pemesanan jelas dan terkontrol
* Mudah digunakan melalui API

Untuk Bisnis
* Struktur backend siap dikembangkan
* Mudah integrasi dengan frontend atau mobile app
* Kontrol akses berbasis role (ADMIN, SELLER, BUYER)

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

## 🧩 Implementasi Core Backend & API

Setiap fitur diimplementasikan melalui REST API:

Authentication
* Register user
* Login dan generate JWT

Product
* Seller membuat produk

Order
* Buyer membuat order
* Menambahkan item ke order

Payment
* Simulasi pembayaran berdasarkan order

Semua endpoint diakses menggunakan HTTP Method standar (GET, POST).

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
