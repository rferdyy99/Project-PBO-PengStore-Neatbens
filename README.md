# Proyek Aplikasi Desktop Peng Store

-----
## Deskripsi Singkat
Peng Store adalah aplikasi desktop berbasis Java yang dirancang untuk memberikan kemudahan dalam proses pembelian game PlayStation. Aplikasi ini menyediakan antarmuka yang intuitif mulai dari proses pendaftaran akun, login, hingga penjelajahan katalog game yang tersedia.
Pengguna dapat melihat detail lengkap dari setiap game, termasuk harga dan rating. Proses pemesanan dibuat efisien, di mana pengguna hanya perlu mengisi data diri dan melakukan pembayaran dengan memindai kode QRIS yang muncul di struk digital. Jika game yang diinginkan sedang tidak tersedia, aplikasi secara otomatis menawarkan sistem Pre-Order dengan pembayaran uang muka (DP), memastikan pelanggan tetap bisa mendapatkan game idamannya.-----
## Fitur Utama

### 1. Sisi Admin
* **Kelola pesanan/HOMEADMIN:** Menampilkan Pesanan Customer 
* **STOKADMIN:** Menampilkan barang dan stok
* **Manajemen User:** Menampilkan Data user 

### 2. Sisi Customer
* **Login&Daftar/login:** Titik awal bagi pengguna. Form ini digunakan untuk masuk ke akun yang sudah ada atau mendaftar akun baru.
* **Halaman utama/HOMECUST:** Menampilkan halaman sambutan dan beberapa game pilihan setelah user berhasil login.
* **Daftar game/CDCUST,GAMECUSTT1:** Menampilkan katalog game yang tersedia untuk dijual.
* **Detail Game/fifa:**  Menampilkan informasi rinci dari game yang dipilih.
* **Pemesanan/fifa1:** Mengumpulkan data pembeli sebelum memproses pesanan.
* **notifikasi stok habis:**  Memberi tahu pengguna bahwa stok habis dan menawarkan opsi Pre-Order.
* **pre order:** Memproses pemesanan Pre-Order dengan sistem uang muka (DP).
* **struk:** Menampilkan bukti transaksi (pembelian atau Pre-Order) yang bisa disimpan.

-----
## Teknologi yang Digunakan
* **Bahasa Pemrograman:** Java
* **Framework/Library UI:** Java Swing
* **Database:** MySQL (dikelola melalui XAMPP dan phpMyAdmin)
* **Library Eksternal:**
        * **MySQL Connector/J:** Untuk menghubungkan aplikasi Java dengan database MySQL.
	* **core.jar:** Mengubah teks menjadi pola QR Code.
	* **javase.jar:** Menggambar pola tersebut dan menyimpannya menjadi file gambar (.png).
    
-----
## Prasyarat
Sebelum menjalankan aplikasi, pastikan perangkat Anda telah terinstal:
1.  **Java Development Kit (JDK)** versi 8 atau lebih tinggi.
2.  **NetBeans IDE** versi 8.2 atau lebih tinggi.
3.  **XAMPP Control Panel** untuk menjalankan Apache dan MySQL Database.

-----
## Cara Menjalankan Aplikasi

### 1. Pengaturan Database
1.  Nyalakan **Apache** dan **MySQL** dari XAMPP Control Panel.
2.  Buka browser dan akses `http://localhost/phpmyadmin`.
3.  Buat database baru dengan nama `penjualanps`.
4.  Pilih database `penjualanps` yang baru dibuat, lalu buka tab **"SQL"**.
5.  Salin dan tempel **seluruh isi skrip SQL** dari file `DATABASE_SETUP.sql` yang disertakan dalam proyek. Skrip ini akan membuat semua tabel yang diperlukan (`data_login`dll.) sekaligus mengisinya dengan data contoh agar aplikasi bisa langsung diuji.
6.  Klik **"Go"** atau **"Kirim"** untuk menjalankan skrip.

### 2. Cara Lain Memasukkan Database
1.  Nyalakan **Apache** dan **MySQL** dari XAMPP Control Panel.
2.  Buka browser dan akses `http://localhost/phpmyadmin`.
3.  Buat database baru dengan nama `penjualanps`.
4.  Pilih database `penjualanps` yang baru dibuat, lalu buka tab **"Import"**.
5.  Cari dan masukkan database `penjualanps`, lalu kirim.

### 3. Konfigurasi Koneksi Database
1.  Buka proyek di NetBeans.
2.  Cari file `Koneksi.java` (di dalam package `frame`).
3.  Pastikan konfigurasi koneksi sudah sesuai dengan pengaturan MySQL di komputermu. Secara default, konfigurasinya adalah:
    ```java
    String url = "jdbc:mysql://localhost:3306/penjualanps";
    String user = "root";
    String pass = "";
    ```

### 3. Instalasi Library (JAR Files)
1.  Di panel "Projects" NetBeans, klik kanan pada folder **Libraries**.
2.  Pilih **Add JAR/Folder...**.
3.  Buka Folder library didalam file zip.
4.  Cari dan tambahkan semua file `.jar` berikut ke dalam proyek:
    * `mysql-connector-j-9.3.0.jar`
    * `core.jar`
    * `javase.jar`

### 4. Build dan Run
1.  Setelah database dan library siap, klik kanan pada nama proyek di NetBeans.
2.  Pilih **Clean and Build**.
3.  Setelah proses build selesai, cari file `Awal.java` (di package `frame login`).
4.  Klik kanan pada file `Awal.java` dan pilih **Run File**.
5.  Aplikasi peng store siap untuk digunakan!

-----
## Akun untuk Login
Uji aplikasi menggunakan akun di bawah ini 
Role  Admin		Customer
Nama  ferdy		ferdy
Email ferdy@adm.com	ferdy@cust.com
pw    ferdy		ferdy
No    081		123

---
# Panduan Penggunaan Aplikasi PENG Store

---
## CUSTOMER
1. Frame Login & Daftar (login.java)
Fungsi: Titik awal bagi pengguna. Form ini digunakan untuk masuk ke akun yang sudah ada atau mendaftar akun baru.
Komponen:
Input fields untuk: Nama, Email, Password, No Telepon.
Tombol Daftar untuk membuat akun baru.
Tombol Login untuk masuk ke aplikasi.
2. Frame Halaman Utama (HOMECUST.java)
Fungsi: Menampilkan halaman sambutan dan beberapa game pilihan setelah user berhasil login.
Komponen:
Tombol Games untuk menuju ke halaman daftar game (CDCUST).
Tombol Kunjungi pada setiap game yang berfungsi sama seperti tombol Games.
Tombol Hubungi kami yang akan mengarahkan pengguna ke nomor WhatsApp admin.
3. Frame Daftar Game (CDCUST.java & GAMECUSTT1.java)
Fungsi: Menampilkan katalog game yang tersedia untuk dijual.
Komponen:
Daftar game beserta gambar sampul dan harga.
Tombol Detail pada setiap game untuk melihat informasi lebih lengkap.
Tombol Lebih banyak (CDCUST) untuk menampilkan lebih banyak game di frame GAMECUSTT1.
4. Frame Detail Game (fifa.java)
Fungsi: Menampilkan informasi rinci dari game yang dipilih.
Komponen:
Informasi: Nama Game, Multiplayer, Platform, Rating.
Harga game.
Tombol Pesan untuk memulai proses pembelian.
5. Frame Pemesanan (fifa1.java)
Fungsi: Mengumpulkan data pembeli sebelum memproses pesanan.
Komponen:
Detail game (Nama, ID, Harga).
Input fields untuk: Nama Pembeli, Alamat Pengiriman.
Informasi metode pembayaran (QRIS Only).
Tombol Konfirmasi.
6. Notifikasi Stok Habis
Fungsi: Memberi tahu pengguna bahwa stok habis dan menawarkan opsi Pre-Order.
Komponen:
Pesan notifikasi.
Tombol Yes untuk melanjutkan ke Pre-Order.
Tombol No untuk membatalkan.
7. Frame Pre-Order (fifa2.java)
Fungsi: Memproses pemesanan Pre-Order dengan sistem uang muka (DP).
Komponen:
Detail Pre-Order (Nama Game, Harga DP, Harga Penuh).
Input fields untuk: Nama Pembeli, Alamat Pengiriman.
Tombol Pre Order untuk mengkonfirmasi.
8. Frame Struk (StrukFrame_1.java)
Fungsi: Menampilkan bukti transaksi (pembelian atau Pre-Order) yang bisa disimpan.
Komponen:
Header: STRUK PENG STORE.
Detail Pembeli: Nama, Alamat.
Detail Pesanan: Deskripsi (misal: FC 25 atau DP Pre Order FC 25), Harga.
Total pembayaran dan Metode Pembayaran (QRIS).
Kode QRIS untuk pembayaran.
Tombol Simpan untuk menyimpan struk.
---


## 3.(Tampilan) Admin
1. Frame HOMEADMIN (Kelola Pesanan)
Ini adalah halaman pertama yang dilihat admin setelah login. Halaman ini berfungsi sebagai dasbor utama untuk memantau dan mengelola semua pesanan yang masuk dari customer.

Fungsi Utama:

Menampilkan seluruh data pesanan customer dalam sebuah tabel yang informatif.
Memungkinkan admin untuk mengubah status setiap pesanan secara efisien.
Komponen:

Tabel Pesanan: Menampilkan detail pesanan dengan kolom: ID, Nama Game, Harga, Nama Pembeli, Alamat, Metode, dan Status.
Navigasi Menu: Terdapat menu di bagian atas untuk pindah ke halaman Inventaris dan Manajemen User.
Ubah Status: Di bagian bawah, terdapat combo box (menu dropdown) yang berisi pilihan status pesanan (contoh: "Menunggu pembayaran", "Terbayar", "Dikirim"). Admin dapat memilih pesanan dari tabel, memilih status baru dari combo box, lalu mengklik tombol Ubah untuk memperbarui status pesanan tersebut.
2. Frame STOKADMIN (Inventaris)
Halaman ini diakses dengan mengklik menu "Inventaris". Halaman ini didedikasikan untuk manajemen stok barang atau game yang dijual di toko.

Fungsi Utama:

Menampilkan daftar semua barang/game yang ada di inventaris.
Menyediakan fungsionalitas untuk menambah barang baru atau memperbarui jumlah stok yang ada.
Komponen:

Tabel Inventaris: Menampilkan daftar barang dengan kolom seperti ID, Nama barang, Stok, Harga Beli, Harga Jual, dan Supplier.
Form Tambah/Update Barang: Di bagian bawah, terdapat form untuk menambah data barang baru atau mengedit yang sudah ada. Admin bisa mengisi Nama Barang, STOK, Harga Beli, Harga Jual, dan Supplier.
Tombol Aksi:
tambah barang: Kemungkinan untuk membersihkan form atau menyiapkan penambahan barang baru.
Simpan: Untuk menyimpan data barang baru atau perubahan pada barang yang sudah ada ke dalam database.
3. Frame ManajemenUser
Halaman ini diakses melalui menu "Manajemen User" dan berfungsi untuk menampilkan data semua pengguna yang terdaftar di sistem.

Fungsi Utama:

Memberikan akses kepada admin untuk melihat daftar seluruh pengguna, baik itu customer maupun admin lain.
Menyediakan fungsi dasar seperti refresh data dan logout dari sistem.
Komponen:

Tabel User: Menampilkan daftar pengguna dengan kolom Email, Nama Lengkap, No. Telepon, dan Posisi (untuk membedakan antara 'Admin' dan 'Customer').
Tombol Refresh: Ketika diklik, akan memuat ulang data pengguna dari database untuk memastikan data yang ditampilkan adalah yang paling baru.
Tombol Log out: Mengeluarkan admin dari sesi saat ini dan mengembalikannya ke halaman login.
